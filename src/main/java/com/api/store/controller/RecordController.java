package com.api.store.controller;

import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;
import com.api.store.model.dto.SaleDTO;
import com.api.store.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/record")
public class RecordController {
    @Autowired
    private IRecordService iRecordService;
    @PostMapping("/save")
    public ResponseEntity<RecordDTO> save(@RequestBody RecordRegistrationRequest recordRegistrationRequest){
        RecordDTO record = iRecordService.save(recordRegistrationRequest);
        if(record!=null){
            return new ResponseEntity<>(record, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<RecordDTO> findById(@PathVariable("id") Long id){
        RecordDTO record = iRecordService.findById(id);
        if(record!=null){
            return new ResponseEntity<>(record,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Set<RecordDTO>> findAll(){
        Set<RecordDTO> list = iRecordService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("{id}/sale")
    public ResponseEntity<?> addSale(@RequestBody SaleDTO saleDTO, @PathVariable("id") Long id){
        boolean isAdded = iRecordService.addSale(saleDTO,id);
        return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/sale")
    public ResponseEntity<?> removeSale(@RequestBody SaleDTO saleDTO, @PathVariable("id") Long id){
        boolean isAdded = iRecordService.removeSale(saleDTO,id);
        return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
