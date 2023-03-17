package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.ProductModel;
import io.github.leandrocvt.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductModel save(@RequestBody @Valid ProductModel productModel){
        return productRepository.save(productModel);
    }

    @GetMapping("{id}")
    public ProductModel findById(@PathVariable Integer id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        productRepository.findById(id).map(p -> {
            productRepository.delete(p);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));

    }

    @PutMapping(value = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid ProductModel productModel){
        productRepository.findById(id).map(p -> {
            productModel.setId(p.getId());
            productRepository.save(productModel);
            return productModel;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));
    }

    @GetMapping
    public List<ProductModel> find(ProductModel filterProduct){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filterProduct, matcher);
        return productRepository.findAll(example);
    }
}
