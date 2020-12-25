package com.zcn.controller;

import com.zcn.dto.CategorySaveDto;
import com.zcn.dto.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class Category {

    @PostMapping
    private ResponseEntity save(@RequestBody CategorySaveDto categorySaveDto){
        ResponseEntity  responseEntity = new ResponseEntity();
        responseEntity.setMessage(categorySaveDto.getKategoriAdi()+" Sisteme kaydedildi.");
        return responseEntity;

    }
}
