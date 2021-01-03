package com.zcn.dto;

import java.math.BigDecimal;

public class ProductDto {

    private  String id;
    private  String urunAdi;
    private BigDecimal fiyat;
    private  BigDecimal adet;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public BigDecimal getAdet() {
        return adet;
    }

    public void setAdet(BigDecimal adet) {
        this.adet = adet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
