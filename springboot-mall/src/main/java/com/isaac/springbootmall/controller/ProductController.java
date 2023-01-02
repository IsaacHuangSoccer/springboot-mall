package com.isaac.springbootmall.controller;

import com.isaac.springbootmall.constant.ProductGategory;
import com.isaac.springbootmall.dao.ProductQueryParams;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;
import com.isaac.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController

//要加上這個註解，@Max & @Min 才能生效
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            //查詢條件 Filtering
           @RequestParam(required = false) ProductGategory category,
           @RequestParam(required = false) String search,

           //排序Sorting
           @RequestParam(defaultValue = "created_date")  String orderBy,
           @RequestParam(defaultValue = "desc ")  String sort,

            //分頁 Pagination

           @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
           @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        List<Product> productList = productService.getProducts(productQueryParams);

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
