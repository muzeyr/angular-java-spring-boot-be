package com.zcn.dto;

import com.zcn.entity.Musteri;
import com.zcn.entity.Product;

import java.util.List;

public class SiparisSaveDto {

    private String id;
    private Musteri musteri;
    private Product product[];

    public SiparisSaveDto(String id, Musteri musteri, Product[] product) {
        this.id = id;
        this.musteri = musteri;
        this.product = product;
    }
}

