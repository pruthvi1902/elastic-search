package com.demo.elasticsearch.service.impl;

import com.demo.elasticsearch.model.Product;
import com.demo.elasticsearch.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public Product createProduct(Product product) {
        log.info("creating product: {}", product);
        try{
            elasticsearchOperations.save(product);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("error while creating product");
        }
        return null;
    }
}
