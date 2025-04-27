package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.ProductDTO;
import com.example.RestGestionPedidos.Entity.Product;
import com.example.RestGestionPedidos.Helper.ProductHelper;

import java.util.ArrayList;

public interface IProductService {
    // GET obtener todos los productos
    ArrayList<ProductDTO> getAllProducts();
    // GET obtener producto por id
    ProductDTO getProduct(int id);
    // POST guardar productos en Arraylist
    Product createProduct(ProductHelper productHelper);
    // DELETE borrar producto de ArrayList
    void deleteProduct(int id);
    // UPDATE actualizar producto
    Product updateProduct(int id, Product productoActualizado);
}
