package com.josedev.market.persistance.crud;

import com.josedev.market.persistance.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository  extends CrudRepository<Producto, Integer> {
    /**
     * The extends only requires two parameters, the entity and main id key type
     */


    /**
     * findBy<nombre_parametro>OrderBy<nombre_parametro>Asc(int idCategoria)
     *
     * Its very important htat you must respect the name of then to allow Spring makes the "magic", using camel case
     *
     * @param idCategoria
     * @return List of products
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
