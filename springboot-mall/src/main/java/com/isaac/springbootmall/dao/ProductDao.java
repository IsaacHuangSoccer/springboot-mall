package com.isaac.springbootmall.dao;

import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
