package com.dev.service;

import com.dev.dto.ProductDTO;
import com.dev.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.*;

import static com.dev.mapper.ProductMapper.*;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository repository;

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>();

        repository.findAll().stream().forEach(item -> {
            products.add(fromProductToProductDTO(item));
        });

        return products;
    }

    public ProductDTO findById(Long id) {
        return fromProductToProductDTO(repository.findById(id));
    }

    @Transactional
    public void save(ProductDTO product) {
        repository.persist(fromProductDTOToProduct(product));
    }

    @Transactional
    public void update(Long id, ProductDTO dto) {
        var product = repository.findById(id);
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setModel(dto.getModel());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());

        repository.persist(product);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
