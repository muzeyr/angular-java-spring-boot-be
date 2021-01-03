package com.zcn.controller;

import com.zcn.dto.CategorySaveDto;
import com.zcn.dto.ResponseEntity;
import com.zcn.dto.SiparisSaveDto;
import com.zcn.entity.Category;
import com.zcn.entity.Product;
import com.zcn.entity.Siparis;
import com.zcn.repository.CategoryRepository;
import com.zcn.repository.ProductRepository;
import com.zcn.repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/siparis")
@CrossOrigin
public class SiparisController {

    @Autowired
    SiparisRepository siparisRepository;




    @GetMapping
    private  ResponseEntity find(){
        ResponseEntity  responseEntity = new ResponseEntity();
        var list = siparisRepository.findAll();
        responseEntity.setData(list);
        responseEntity.setMessage("Veriler başarıyla çekildi");
        responseEntity.setType("S");
        return responseEntity;
    }

    @PostMapping
    private ResponseEntity save(@RequestBody SiparisSaveDto siparisSaveDto){
        ResponseEntity  responseEntity = new ResponseEntity();
        var siparis  = new Siparis();

        responseEntity.setObject(siparisRepository.save(siparis));

        return responseEntity;

    }
}
