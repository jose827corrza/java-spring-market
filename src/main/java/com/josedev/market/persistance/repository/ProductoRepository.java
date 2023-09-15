package com.josedev.market.persistance.repository;

import com.josedev.market.domain.Product;
import com.josedev.market.domain.repository.ProductRepository;
import com.josedev.market.persistance.crud.ProductCrudRepository;
import com.josedev.market.persistance.entities.Producto;
import com.josedev.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Specific annotation, more than @Component
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productoRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = productoRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoRepository.findById(productId).map(product -> mapper.toProduct(product));
    }


    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoRepository.deleteById(productId);
    }


}
