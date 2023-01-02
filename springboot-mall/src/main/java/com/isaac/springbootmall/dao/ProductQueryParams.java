package com.isaac.springbootmall.dao;

import com.isaac.springbootmall.constant.ProductGategory;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductQueryParams {

    ProductGategory category;
    String search;

    public ProductGategory getCategory() {
        return category;
    }

    public void setCategory(ProductGategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
