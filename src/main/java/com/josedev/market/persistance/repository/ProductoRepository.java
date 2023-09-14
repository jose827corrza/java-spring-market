package com.josedev.market.persistance.repository;

import com.josedev.market.persistance.crud.ProductCrudRepository;
import com.josedev.market.persistance.entities.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductCrudRepository productoRepository;

    public List<Producto> getAllProducts(){
        return (List<Producto>) productoRepository.findAll();
    }
}
