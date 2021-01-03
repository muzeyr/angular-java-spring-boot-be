package com.zcn.controller;

import com.zcn.dto.MusteriSaveDto;
import com.zcn.dto.ResponseEntity;
import com.zcn.entity.Customer;
import com.zcn.repository.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musteri")
@CrossOrigin
public class CustomerController {

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
        Customer musteri = new Customer();
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
