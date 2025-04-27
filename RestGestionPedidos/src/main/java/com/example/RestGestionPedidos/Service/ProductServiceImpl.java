package com.example.RestGestionPedidos.Service;

import com.example.RestGestionPedidos.DTO.ClienteDTO;
import com.example.RestGestionPedidos.DTO.ProductDTO;
import com.example.RestGestionPedidos.Entity.Cliente;
import com.example.RestGestionPedidos.Entity.Product;
import com.example.RestGestionPedidos.Helper.ProductHelper;
import com.example.RestGestionPedidos.Mapper.ClienteMapper;
import com.example.RestGestionPedidos.Mapper.ProductMapper;
import com.example.RestGestionPedidos.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements IProductService {
    //Para inyección de dependencias
    private ProductRepository productRepository;
    //Para inyección de dependencias
    private ProductMapper mapper;

    // Constructor donde se le inyecta el bean de productRepository
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    // GET obtener todos los productos
    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        // Recibe Arraylist de Clientes, para luego en el foreach convertirla a ClienteDTO
        ArrayList<Product> productsList = productRepository.findAll();
        // Creamos una ArrayList de ProductsDTO (guardará aquí los convertidos de Product a ProductDTO)
        ArrayList<ProductDTO> dtoListProducts = new ArrayList<>();
        // Conversion de Products a ProductsDTO
        for(Product product : productsList) {
            ProductDTO productDTO = mapper.toProductDTO(product);
            dtoListProducts.add(productDTO);
        }
        // Se regresa la lista de ProductsDTO
        return dtoListProducts;
    }

    // GET obtener producto por id
    @Override
    public ProductDTO getProduct(int id) {
        // Se guarda en una referencia a Product
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RuntimeException("Order Not found"));
        // Se realiza la conversión de Product a ProductDTO
        ProductDTO productDTO = mapper.toProductDTO(product);
        return productDTO;
    }

    // POST guardar productos en Arraylist
    @Override
    public Product createProduct(ProductHelper productHelper) {
        Product product = mapper.toProduct(productHelper);
        return productRepository.saveProduct(product);
    }

    // DELETE borrar producto de ArrayList
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProductById(id);
    }

    // UPDATE actualizar producto
    @Override
    public Product updateProduct(int id, Product productActualizado) {
        return productRepository.updateProductById(id, productActualizado)
                .orElseThrow(() -> new RuntimeException("No se pudo actualizar porque no se encontró al Producto con ID: " + id));
    }
}
