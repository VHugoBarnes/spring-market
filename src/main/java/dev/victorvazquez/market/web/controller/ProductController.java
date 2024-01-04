package dev.victorvazquez.market.web.controller;

import dev.victorvazquez.market.domain.Product;
import dev.victorvazquez.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(
            productService.getAll(),
            HttpStatus.OK
        );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId")  int productId) {
        return productService.getProduct(productId)
          .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
          .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
          .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
          .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int productId) {
        return new ResponseEntity<>(productService.delete(productId), HttpStatus.OK);
    }
}
