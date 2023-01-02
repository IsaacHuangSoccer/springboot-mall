package com.isaac.springbootmall.service;

import com.isaac.springbootmall.dao.ProductQueryParams;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);



    List<Product> getProducts(ProductQueryParams productQueryParams);
}
