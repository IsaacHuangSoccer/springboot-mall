package com.isaac.springbootmall.dao.impl;

import com.isaac.springbootmall.constant.ProductGategory;
import com.isaac.springbootmall.dao.ProductDao;
import com.isaac.springbootmall.dao.ProductQueryParams;
import com.isaac.springbootmall.dto.ProductRequest;
import com.isaac.springbootmall.model.Product;
import com.isaac.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql =
                "select product_id , product_name, category  , image_url, price, stock, description, created_date, last_modified_date " +
                        "From product " +
                        "where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId",productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0){
            return  productList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql =
                "INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) " +
                        "VALUES (:productName, :category, :image_url, :price, :stock, :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("image_url",productRequest.getImage_url());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate",now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int productId = keyHolder.getKey().intValue();


        return productId;
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql =
                "select product_id , product_name, category  , image_url, price, stock, description, created_date, last_modified_date " +
                        "From product " +
                "where 1=1";
        Map<String,Object> map = new HashMap<>();

        if (productQueryParams.getCategory() != null){

            //AND 前面一定要留一個空白鍵
            sql = sql + " AND category= :category";
            map.put("category", productQueryParams.getCategory().name());

        }

        if (productQueryParams.getSearch() != null){
            sql = sql + " AND product_name LIKE :search ";
            map.put("search","%" + productQueryParams.getSearch() + "%");

        }
        //排序
        //不用判斷是否為 null, 因為controller層 有設定defaultvalue

        sql = sql + " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();


        //分頁
        sql = sql + "LIMIT :limit OFFSET :offset";
        map.put("limit", productQueryParams.getLimit());
        map.put("offset", productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return  productList;
    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
       String sql = "SELECT count(*) FROM product where 1=1";

        Map<String,Object> map = new HashMap<>();

        if (productQueryParams.getCategory() != null){

            //AND 前面一定要留一個空白鍵
            sql = sql + " AND category= :category";
            map.put("category", productQueryParams.getCategory().name());

        }

        if (productQueryParams.getSearch() != null){
            sql = sql + " AND product_name LIKE :search ";
            map.put("search","%" + productQueryParams.getSearch() + "%");

        }
       Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return  total;

    }
}
