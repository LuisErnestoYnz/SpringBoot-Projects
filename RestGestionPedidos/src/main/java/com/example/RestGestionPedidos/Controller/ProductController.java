package com.example.RestGestionPedidos.Controller;

import com.example.RestGestionPedidos.DTO.ProductDTO;
import com.example.RestGestionPedidos.Entity.Product;
import com.example.RestGestionPedidos.Helper.ProductHelper;
import com.example.RestGestionPedidos.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @Autowired      // No es necesario poner la anotación por tener 1 solo constructor
    public ProductController(ProductServiceImpl productoServiceImpl) {
        this.productServiceImpl = productoServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productServiceImpl.getAllProducts());
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return productServiceImpl.getProduct(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody ProductHelper productHelper) {
        return ResponseEntity.ok(productServiceImpl.createProduct(productHelper));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productServiceImpl.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productoActualizado) {
        return productServiceImpl.updateProduct(id, productoActualizado);
    }

}
