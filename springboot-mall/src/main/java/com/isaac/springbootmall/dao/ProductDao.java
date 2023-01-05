package com.isaac.springbootmall.dao;

import com.isaac.springbootmall.constant.ProductGategory;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);


    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);
}
