package com.zcn.controller;

import com.zcn.dto.CategorySaveDto;
import com.zcn.dto.MusteriSaveDto;
import com.zcn.dto.ResponseEntity;
import com.zcn.entity.Category;
import com.zcn.entity.Musteri;
import com.zcn.entity.Product;
import com.zcn.repository.CategoryRepository;
import com.zcn.repository.MusteriRepository;
import com.zcn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/musteri")
@CrossOrigin
public class MusteriController {

    @Autowired
    MusteriRepository musteriRepository;




    @DeleteMapping(value = {"", "/"})
    public ResponseEntity delete(@RequestParam final String uuid) {
        ResponseEntity  responseEntity = new ResponseEntity();
        musteriRepository.deleteById(uuid);
        responseEntity.setMessage("Kayıt silindi");
        return responseEntity;
    }

    @GetMapping
    private  ResponseEntity find(){
        ResponseEntity  responseEntity = new ResponseEntity();
        var list = musteriRepository.findAll();
        responseEntity.setData(list);
        responseEntity.setMessage("Veriler başarıyla çekildi");
        responseEntity.setType("S");
        return responseEntity;
    }

    @PostMapping
    private ResponseEntity save(@RequestBody MusteriSaveDto musteriSaveDto){
        ResponseEntity  responseEntity = new ResponseEntity();
        Musteri musteri = new Musteri();
        musteri.setId(musteriSaveDto.getId());
        musteri.setAddress(musteriSaveDto.getAdres());
        musteri.setContent(musteriSaveDto.getAciklama());
        musteri.setName(musteriSaveDto.getAdiSoyadi());
        musteri.setPhone(musteriSaveDto.getTelefon());
        musteriRepository.save(musteri);
        responseEntity.setMessage(musteri.getName()+" sisteme kaydedildi.");
        return responseEntity;

    }
}
