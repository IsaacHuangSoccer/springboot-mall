package com.isaac.springbootmall.dto;

import com.isaac.springbootmall.constant.ProductGategory;
import org.springframework.lang.NonNull;


public class ProductRequest {

    @NonNull
    private String productName;

    @NonNull
    private ProductGategory category      ;

    @NonNull
    private String image_url   ;

    @NonNull
    private Integer price     ;

    @NonNull
    private Integer stock      ;


    private  String description  ;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductGategory getCategory() {
        return category;
    }

    public void setCategory(ProductGategory category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
