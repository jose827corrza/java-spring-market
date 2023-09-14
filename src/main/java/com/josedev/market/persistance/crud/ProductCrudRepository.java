package com.josedev.market.persistance.crud;

import com.josedev.market.persistance.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<Producto, Integer> {
    /**
     * The extends only requires two parameters, the entity and main id key type
     */
}
