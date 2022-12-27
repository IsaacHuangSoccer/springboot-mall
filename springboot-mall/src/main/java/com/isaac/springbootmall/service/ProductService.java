package com.isaac.springbootmall.service;

import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;

public interface ProductService {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
