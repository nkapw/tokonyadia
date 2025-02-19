package com.enigma.tokonyadia.service;

import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.model.request.ProductRequest;
import com.enigma.tokonyadia.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(String id);

    List<Product> getAll();

    Product update(Product product);

    void delete(String id);

    ProductResponse createProduct(ProductRequest productRequest);
}