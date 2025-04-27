package com.example.RestGestionPedidos.Mapper;

import com.example.RestGestionPedidos.DTO.ProductDTO;
import com.example.RestGestionPedidos.Entity.Product;
import com.example.RestGestionPedidos.Helper.ProductHelper;
import org.springframework.stereotype.Component;

@Component      // Ya que generaremos un nuevo bean
public class ProductMapper {
    //Se requiere regresar al product un ProductDTO
    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        // Settear la información de la Entity Product (excepto el id)
        productDTO.setNombre(product.getNombre());
        productDTO.setPrecio(product.getPrecio());
        productDTO.setDescripcion(product.getDescripcion());
        return productDTO;
    }

    //Se requiere regresar al productDTO un Product (ProductDTO -> Product)
    public Product toProduct(ProductHelper productHelper) {
        Product product = new Product();
        /// Settear la información de la Entity ProductHelper(excepto el id)
        product.setNombre(productHelper.getNombre());
        product.setPrecio(productHelper.getPrecio());
        product.setDescripcion(productHelper.getDescripcion());
        return product;
    }
}
