package com.zcn.dto;

import com.zcn.entity.Musteri;
import com.zcn.entity.Product;

import java.util.List;

public class SiparisSaveDto {

    private String id;
    private Musteri musteri;
    private Product product[];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }
}

