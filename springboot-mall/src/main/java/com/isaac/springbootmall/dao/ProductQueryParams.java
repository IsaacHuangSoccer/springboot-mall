package com.isaac.springbootmall.dao;

import com.isaac.springbootmall.constant.ProductGategory;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductQueryParams {

    private ProductGategory category;
    private String search;

    private String orderBy;
    private String sort;

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
