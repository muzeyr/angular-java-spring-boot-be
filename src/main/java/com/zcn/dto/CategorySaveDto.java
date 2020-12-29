package com.zcn.dto;

import java.util.List;

public class CategorySaveDto {

    private String id;
    private String kategoriAdi;

    private List<ProductDto> urunler;

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductDto> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<ProductDto> urunler) {
        this.urunler = urunler;
    }
}

