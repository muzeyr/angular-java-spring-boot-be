package com.zcn.dto;

import com.zcn.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public class SiparisSaveDto {

    private String id;
    private Customer musteri;
    private List<ProductDto> urunler;
    private BigDecimal tutar;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getMusteri() {
        return musteri;
    }

    public void setMusteri(Customer musteri) {
        this.musteri = musteri;
    }

    public List<ProductDto> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<ProductDto> urunler) {
        this.urunler = urunler;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    public void setTutar(BigDecimal tutar) {
        this.tutar = tutar;
    }
}

