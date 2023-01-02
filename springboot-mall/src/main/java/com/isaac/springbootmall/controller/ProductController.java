package com.isaac.springbootmall.controller;

import com.isaac.springbootmall.constant.ProductGategory;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;
import com.isaac.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
           @RequestParam(required = false) ProductGategory category,
           @RequestParam(required = false) String search

    ){
        List<Product> productList = productService.getProducts(category, search);

        return ResponseEntity.status(HttpStatus.OK).body(productList);


    }

    @GetMapping("/index")
// 將Model 作為Controller 的引數，由Spring 框架自動創建並作為參數傳入
    public String model(Model model) {
        // 設定傳遞資料
        model.addAttribute("message","ddddd" );

        // 返回值指定頁面路徑
        return "ddddcdscsdc";
    }



    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
      Product product =  productService.getProductById(productId);

      if (product!= null){
          return ResponseEntity.status(HttpStatus.OK).body(product);
      }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid  ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}
