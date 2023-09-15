package com.josedev.market.persistance.repository;

import com.josedev.market.persistance.crud.ProductCrudRepository;
import com.josedev.market.persistance.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Specific annotation, more than @Component
public class ProductoRepository {

    private ProductCrudRepository productoRepository;

    public List<Producto> getAllProducts(){
        return (List<Producto>) productoRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProduct(int idProducto){
        return productoRepository.findById(idProducto);
    }

    public Producto saveProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProduct(int idProducto){
        productoRepository.deleteById(idProducto);
    }
}
