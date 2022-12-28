package com.isaac.springbootmall.service.impl;

import com.isaac.springbootmall.dao.ProductDao;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;
import com.isaac.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public List<Product> getProducts() {
        return  productDao.getProducts();
    }
}
