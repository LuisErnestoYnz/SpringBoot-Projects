package com.example.RestGestionPedidos.Repository;

import com.example.RestGestionPedidos.Entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final ArrayList<Product> productos = new ArrayList<>();
    // Se simula la autogeneración del id con esta propiedad.
    private int nextId;

    public ProductRepository() {
        //Se agregan Productos al ArrayList para que cada que la aplicación inicie estén estos datos
        productos.add(new Product(1, "Celular", 12500.00, "Celular Marca Samsung"));
        productos.add(new Product(2, "Laptop", 14600.00, "Laptop modelo 5660 marca Dell"));
    }

    // Lee todos los productos (GET)
    public ArrayList<Product> findAll(){
        return productos;
    }

    // Lee productos por id (GET)
    public Optional<Product> getProductById(int id) {
        return productos.stream().filter(producto -> producto.getId() == id).findFirst();
    }

    // Escribe un producto (POST)
    public Product saveProduct(Product producto) {
        nextId = productos.size() + 1;
        producto.setId(nextId);
        productos.add(producto);
        return producto;
    }

    // Borrar un producto por Id (DELETE)
    public void deleteProductById(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    // Actualiza un producto por Id
    public Optional<Product> updateProductById(int id, Product productoActualizado) {
        return getProductById(id).map(productoExistente -> {
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            return productoExistente;
        });
    }

}
