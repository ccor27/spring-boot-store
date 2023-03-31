package com.api.store.service;

import com.api.store.model.*;
import com.api.store.model.Record;
import com.api.store.model.dto.*;
import com.api.store.repository.CustomerRepository;
import com.api.store.repository.RoleRepository;
import com.api.store.repository.TokenRepository;
import com.api.store.service.mapper.CustomerDTOMapper;
import com.api.store.service.mapper.SaleDTOMapper;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements ICustomerService{

    private static final Logger LOGGER= LoggerFactory.getLogger(SLF4JLogger.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerDTOMapper customerDTOMapper;
    @Autowired
    private SaleDTOMapper saleDTOMapper;
    @Autowired
    private ISaleService iSaleService;
    @Autowired
    private IRecordService iRecordService;
    @Autowired
    private IAddressService iAddressService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * Method to create (register) a new customer
     * @param customerRegistrationRequest
     * @return
     */
    @Override
    public CustomerAuthenticateResponse register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = null;

        if(customerRegistrationRequest.address()!=null) {
            customer = new Customer(
                    customerRegistrationRequest.name(),
                    customerRegistrationRequest.lastName(),
                    customerRegistrationRequest.email(),
                    customerRegistrationRequest.phone(),
                    customerRegistrationRequest.username(),
                    passwordEncoder.encode(customerRegistrationRequest.pwd()),
                    convertAddressRegistrationToAddressDTO(customerRegistrationRequest.address()),
                    new HashSet<>()
            );
        }else{

            customer = new Customer(
                    customerRegistrationRequest.name(),
                    customerRegistrationRequest.lastName(),
                    customerRegistrationRequest.email(),
                    customerRegistrationRequest.phone(),
                    customerRegistrationRequest.username(),
                    passwordEncoder.encode(customerRegistrationRequest.pwd()),
                    new HashSet<>()
            );
        }

        Role role = roleRepository.findById(1L).orElse(null);
        customer.getRoles().add(role);
        customerRepository.save(customer);
        LOGGER.info(customer.toString());
        String jwtToken = jwtService.generateToken(customer);
        saveCustomerToken(customer, jwtToken);
        LOGGER.info("CUSTOMER: customer creates successfully");
        return new CustomerAuthenticateResponse(jwtToken);

    }

    @Override
    public CustomerAuthenticateResponse authenticate(CustomerAuthentication customerAuthentication) {

        String username =customerAuthentication.getUsername();
        String password = customerAuthentication.getPassword();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,password
                    )
            );
        Customer customer = customerRepository.findByUsername(customerAuthentication.getUsername()).orElseThrow(() -> new UsernameNotFoundException("The username is incorrect"));
        LOGGER.info(customer.toString());
        String jwtToken = jwtService.generateToken(customer);
        revokeAllCustomerTokens(customer);
        saveCustomerToken(customer, jwtToken);
        return new CustomerAuthenticateResponse(jwtToken);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer!=null){
            LOGGER.info("CUSTOMER: customer found successfully");
            return customerDTOMapper.apply(customer);
        }else{
            LOGGER.error("CUSTOMER: the customer doesn't exist");
            return null;
        }
    }

    @Override
    public CustomerDTO updateInfo(CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = customerRepository.findById(customerUpdateRequest.id()).orElse(null);
        if(customer!=null){

            customer.setId(customerUpdateRequest.id());
            customer.setName(customerUpdateRequest.name());
            customer.setLastName(customerUpdateRequest.lastName());
            customer.setEmail(customerUpdateRequest.email());
            customer.setPhone(customerUpdateRequest.phone());
            customerRepository.save(customer);
            LOGGER.info("CUSTOMER: customer updated successfully");
            return customerDTOMapper.apply(customer);
        }else{
            LOGGER.error("CUSTOMER: the customer doesn't exist");
            return null;
        }
    }

    @Override
    public Set<CustomerDTO> findAll() {
        LOGGER.info("CUSTOMER: customers found successfully");
        /**
         * yv3ZhL
         * eH5WfS5Np
         * ocqca8
         * lPeVnRhtf
         * 29XuVogKMiA
         */

        return customerRepository.findAll().stream().map(customer -> {
            return customerDTOMapper.apply(customer);
        }).collect(Collectors.toSet());
    }

    @Override
    public Customer findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer!=null){
            LOGGER.info("CUSTOMER: customer found successfully");
            return customer;
        }else{
            LOGGER.error("CUSTOMER: customer doesn't exist");
            return null;
        }
    }

    /**
     *
     *
     * @param recordDTO
     * @param id
     * @return
     */
    @Override
    public CustomerDTO addRecord(RecordDTO recordDTO, Long id) {

     Record record = iRecordService.findRecordById(recordDTO.id());

     if(record!=null){

         Customer customer = customerRepository.findById(id).orElse(null);
         if(!haveRecordCustomer(record) && customer!=null){
             customer.setRecord(record);
             customerRepository.save(customer);
             LOGGER.info("CUSTOMER: record added successfully");
             return customerDTOMapper.apply(customer);
         }else {
             LOGGER.error("CUSTOMER: record have already a customer or the customer doesn't exist, therefore the relationship is impossible");
             return null;
         }
     }else{
         LOGGER.error("CUSTOMER: the record doesn't exist, therefore is not possible add it make this operation");
         return null;
     }
    }

    private boolean haveRecordCustomer(Record record) {
        return record.getCustomer()!=null?true:false;
    }

    @Override
    public RecordDTO findRecordCustomer(Long id) {
        Customer customer = findCustomerById(id);
        if(customer!=null){
            if(customer.getRecord()!=null){
                LOGGER.info("CUSTOMER: record found successfully");
                return iRecordService.findById(customer.getRecord().getId());
            }else {
                LOGGER.error("CUSTOMER: there isn't a record in the customer");
                return null;
            }
        }else{
            LOGGER.error("CUSTOMER: the customer doesn't exist");
            return null;
        }
    }


    @Override
    public boolean addSaleInRecord(SaleDTO saleDTO, Long id) {


      if(iSaleService.findSaleById(saleDTO.id())==null) {
          LOGGER.error("CUSTOMER: the sale doesn't exist, therefore is not possible and it to the record");
          return false;
      }

      Customer customer = customerRepository.findById(id).orElse(null);
      if(customer==null) {
          LOGGER.error("CUSTOMER: the customer: " + id + " doesn't exist, therefore is not possible add the sale into the record");
          return false;
      }

      Record record =customer.getRecord();
      if(record==null) {
          LOGGER.error("CUSTOMER: the record doesn't exist, therefore is not possible add a sale it");
          return false;
      }


      if(iRecordService.addSale(saleDTO, record.getId())){
          customerRepository.save(customer);
          LOGGER.info("CUSTOMER: sale add into record successfully");
          return true;
      }

      return false;//this is by default ;)
    }

    @Override
    public boolean deleteSaleInRecord(SaleDTO saleDTO, Long id) {

        if(iSaleService.findSaleById(saleDTO.id())==null) {
            LOGGER.error("CUSTOMER: the sale doesn't exist, therefore is not possible remove it to the record");
            return false;
        }

        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer==null) {
            LOGGER.error("CUSTOMER: the customer: " + id + " doesn't exist, therefore is not possible remove the sale into the record");
            return false;
        }

        Record record =customer.getRecord();
        if(record==null) {
            LOGGER.error("CUSTOMER: the record doesn't exist, therefore is not possible remove a sale it");
            return false;
        }


        if(iRecordService.removeSale(saleDTO, record.getId())){
            customerRepository.save(customer);
            LOGGER.info("CUSTOMER: sale remove into record successfully");
            return true;
        }
        return false;//this is by default ;)
    }

    @Override
    public CustomerDTO addAddress(AddressRegistrationRequest addressRegistrationRequest, Long id) {

        Customer customer = findCustomerById(id);
        if(customer==null){
            LOGGER.error("CUSTOMER: the customer doesn't exist or the address send is null, therefore is not possible make the operation");
            return null;
        }else{
            customer.setAddress(convertAddressRegistrationToAddressDTO(addressRegistrationRequest));
            customerRepository.save(customer);
            LOGGER.info("CUSTOMER: address added to customer successfully");
            return customerDTOMapper.apply(customer);
        }


    }

    @Override
    public CustomerDTO removeAddress(AddressDTO addressDTO, Long id) {
        Customer customer = findCustomerById(id);
        if(customer==null){
            LOGGER.error("CUSTOMER: the customer doesn't exist, therefore is not possible make the operation");
            return null;
        }else{
            Address address = iAddressService.findAddressById(addressDTO.id());
            if(address!=null) {
                customer.setAddress(null);
                customerRepository.save(customer);
                LOGGER.info("CUSTOMER: address removed to customer successfully");
                return customerDTOMapper.apply(customer);
            }else{
                LOGGER.error("CUSTOMER: the address doesn't exist, therefore is not possible make the operation");
                return null;
            }
        }
    }
    @Override
    public AddressDTO findAddressCustomer(Long id) {
        Customer customer = findCustomerById(id);
        if(customer!=null){
            if(customer.getAddress()!=null){
                LOGGER.info("CUSTOMER: customer's address found successfully");
                return iAddressService.findById(customer.getAddress().getId());
            }else{
                LOGGER.error("CUSTOMER: the customer doesn't have an address");
                return null;
            }
        }else {
            LOGGER.error("CUSTOMER: the customer doesn't exist");
            return null;
        }
    }

    private void saveCustomerToken(Customer customer, String jwtToken) {
        Token token = new Token(
                jwtToken,
                TokenType.BEARER,
                false,
                false,
                customer
        );
        tokenRepository.save(token);
    }
    private void revokeAllCustomerTokens(Customer customer){
        List<Token> validCustomerTokens = tokenRepository.findAllValidTokenByCustomer(customer.getId());
        if(validCustomerTokens.isEmpty())
            return;
        validCustomerTokens.forEach(t->{
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validCustomerTokens);
    }

    private Address convertAddressRegistrationToAddressDTO(AddressRegistrationRequest addressRegistrationRequest){

        if(addressRegistrationRequest!=null) {
            Address address = new Address(
                    addressRegistrationRequest.street(),
                    addressRegistrationRequest.country(),
                    addressRegistrationRequest.zip_code(),
                    addressRegistrationRequest.city(),
                    addressRegistrationRequest.state()
            );
            return address;
        }
        return null;
    }
}
