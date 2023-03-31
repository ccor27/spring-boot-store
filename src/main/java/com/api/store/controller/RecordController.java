package com.api.store.controller;

import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;
import com.api.store.model.dto.SaleDTO;
import com.api.store.service.IRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/record")
@Tag(name = "Record controller",description = "Set of endpoint of record")
@SecurityRequirement(name = "Bearer Authentication")
public class RecordController {
    private HashMap<String,String> errors = new HashMap<>();
    @Autowired
    private IRecordService iRecordService;
    @PostMapping("/save")
    @Operation(summary = "Save",description="To save a new record")
    public ResponseEntity<?> save(@RequestBody RecordRegistrationRequest recordRegistrationRequest){
        RecordDTO record = iRecordService.save(recordRegistrationRequest);
        if(record!=null){
            return new ResponseEntity<>(record, HttpStatus.CREATED);
        }else{
            errors.clear();
            errors.put("Error","Error during the saving record");
            return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    @Operation(summary = "Find by id",description="To get a record by its id")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        RecordDTO record = iRecordService.findById(id);
        if(record!=null){
            return new ResponseEntity<>(record,HttpStatus.FOUND);
        }else{
            errors.clear();
            errors.put("Error","The record doesn't exist");
            return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    @Operation(summary = "Find all",description="To get all records")
    public ResponseEntity<?> findAll(){
        Set<RecordDTO> list = iRecordService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }else{
            errors.clear();
            errors.put("Error","The list fo records is empty");
            return new ResponseEntity<>(errors,HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("{id}/sale")
    @Operation(summary = "Add sale",description="To add a new sale to specific record")
    public ResponseEntity<?> addSale(@RequestBody SaleDTO saleDTO, @PathVariable("id") Long id){
        boolean isAdded = iRecordService.addSale(saleDTO,id);
        errors.clear();
        errors.put("Info","There is a problem, it could be caused for three reasons");
        errors.put("Error 1","Possibly the error was caused by the sale doesn't exist");
        errors.put("Error 2","Possibly the error was caused by the sale is already in another record");
        errors.put("Error 3","Possibly the error was caused by the record doesn't exist");
        return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/sale")
    @Operation(summary = "Remove sale",description="To remove a sale from speOperation")
    public ResponseEntity<?> removeSale(@RequestBody SaleDTO saleDTO, @PathVariable("id") Long id){
        boolean isAdded = iRecordService.removeSale(saleDTO,id);
        errors.clear();
        errors.put("Info","There is a problem, it could be caused for two reasons");
        errors.put("Error 1","Possibly the error was caused by the sale doesn't exist");
        errors.put("Error 2","Possibly the error was caused by the record doesn't exist");
        return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
