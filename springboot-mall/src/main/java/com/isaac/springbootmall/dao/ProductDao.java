package com.isaac.springbootmall.dao;

import com.isaac.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);
}
