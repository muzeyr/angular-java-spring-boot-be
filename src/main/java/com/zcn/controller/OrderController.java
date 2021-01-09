package com.zcn.controller;

import com.zcn.dto.ResponseEntity;
import com.zcn.dto.SiparisSaveDto;
import com.zcn.entity.Order;
import com.zcn.entity.Product;
import com.zcn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/siparis")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderRepository siparisRepository;




    @DeleteMapping(value = {"", "/"})
    public ResponseEntity delete(@RequestParam final String uuid) {
        ResponseEntity  responseEntity = new ResponseEntity();
        siparisRepository.deleteById(uuid);
        responseEntity.setMessage("Kayıt silindi");
        return responseEntity;
    }


    @GetMapping
    private  ResponseEntity find(){
        ResponseEntity  responseEntity = new ResponseEntity();
        var list = siparisRepository.findAll();
        responseEntity.setData(list);
        responseEntity.setMessage("Veriler başarıyla çekildi");
        responseEntity.setType("S");
        return responseEntity;
    }
    @PostMapping(value = {"weekly", "/weekly"})
    private  ResponseEntity weekly(){

        var startDate= LocalDateTime.now();
        var lastDate=startDate.minusDays(7);
        ResponseEntity  responseEntity = new ResponseEntity();
        var list = siparisRepository.getAllBetweenDates(startDate,lastDate);
        responseEntity.setData(list);
        responseEntity.setMessage("Veriler başarıyla çekildi");
        responseEntity.setType("S");
        return responseEntity;
    }
    @PostMapping
    private ResponseEntity save(@RequestBody SiparisSaveDto siparisSaveDto){
        ResponseEntity  responseEntity = new ResponseEntity();
        var productList = new ArrayList<Product>();

        var order  = new Order();
        order.setTotalPrice(siparisSaveDto.getTutar());
        order.setCustomer(siparisSaveDto.getMusteri());
        order.setCreatedAt(LocalDateTime.now());
        siparisSaveDto.getUrunler().forEach(item ->{
            var product = new Product();
            product.setProductName(item.getUrunAdi());
            product.setPrice(item.getFiyat());
            product.setQuantity(item.getAdet());
            product.setId(item.getId());
            productList.add(product);
        });
        order.setProducts(productList);
        responseEntity.setObject(siparisRepository.save(order));

        return responseEntity;

    }
}
