package com.zcn.controller;


import com.zcn.dto.ResponseEntity;
import com.zcn.entity.User;
import com.zcn.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    private ResponseEntity list(){
        List<User> tmpList = new ArrayList<>();
        User user = new User();
        user.setAdiSoyadi("UZEYR ÖZCAN");
        user.seteMail("muzeyr@gmail.com");
        user.setMobilePhone("5074606083");
        tmpList.add(user);

        User user2 = new User();
        user2.setAdiSoyadi("KAMIL DEMIR");
        user2.seteMail("kamil.demir@gmail.com");
        user2.setMobilePhone("599 500 40 83");
        tmpList.add(user2);
        ResponseEntity  responseEntity = new ResponseEntity();
        responseEntity.setData(tmpList);
        responseEntity.setType("S");
        responseEntity.setMessage("Listeleme başarılı");
        return responseEntity;
    }


    @PostMapping
    private ResponseEntity  save(@RequestBody User user){
        ResponseEntity  responseEntity = new ResponseEntity();
        usersRepository.save(user);
        responseEntity.setMessage(user.getAdiSoyadi()+" sisteme kaydedildi");
        responseEntity.setObject(user);
        return responseEntity;
    }

}
