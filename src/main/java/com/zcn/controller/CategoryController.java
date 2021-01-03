package com.zcn.controller;

import com.zcn.dto.CategorySaveDto;
import com.zcn.dto.ProductDto;
import com.zcn.dto.ResponseEntity;
import com.zcn.entity.Category;
import com.zcn.entity.Product;
import com.zcn.repository.CategoryRepository;
import com.zcn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/find-category/{uuid}")
    public ResponseEntity findCategory(@PathVariable final String uuid) {
        ResponseEntity  responseEntity = new ResponseEntity();
        responseEntity.setObject(categoryRepository.findById(uuid));
        responseEntity.setMessage("Kayıt başarıyla çekildi");
        return responseEntity;
    }
    @DeleteMapping(value = {"", "/"})
    public ResponseEntity delete(@RequestParam final String uuid) {
        ResponseEntity  responseEntity = new ResponseEntity();
        categoryRepository.deleteById(uuid);
        responseEntity.setMessage("Kayıt silindi");
        return responseEntity;
    }

    @GetMapping
    private  ResponseEntity find(){
        ResponseEntity  responseEntity = new ResponseEntity();
        var list = categoryRepository.findAll();
        responseEntity.setData(list);
        responseEntity.setMessage("Veriler başarıyla çekildi");
        responseEntity.setType("S");
        return responseEntity;
    }

    @PostMapping
    private ResponseEntity save(@RequestBody CategorySaveDto categorySaveDto){
        ResponseEntity  responseEntity = new ResponseEntity();
        Category category = new Category();
        category.setId(categorySaveDto.getId());
        category.setCategoryName(categorySaveDto.getKategoriAdi());
        category.setVersion("v111");
        var productList = new ArrayList<Product>();

        categorySaveDto.getUrunler().forEach(item ->{
            var product = new Product();
            product.setProductName(item.getUrunAdi());
            product.setPrice(item.getFiyat());
            product.setId(item.getId());
            productList.add(product);
        });
        productRepository.saveAll(productList);
        category.setProducts(productList);

        responseEntity.setObject(categoryRepository.save(category));
        responseEntity.setMessage(categorySaveDto.getKategoriAdi()+" Kategoriler sisteme kaydedildi.");
        return responseEntity;

    }
}
