package com.zcn.dto;

public class CategorySaveDto {
    private String kategoriAdi;
    private ProductDto[] productDto;

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public ProductDto[] getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto[] productDto) {
        this.productDto = productDto;
    }
}
