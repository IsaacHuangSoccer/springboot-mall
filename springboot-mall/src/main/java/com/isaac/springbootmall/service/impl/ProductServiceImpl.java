package com.isaac.springbootmall.service.impl;

import com.isaac.springbootmall.dao.ProductDao;
import com.isaac.springbootmall.model.Product;
import com.isaac.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}