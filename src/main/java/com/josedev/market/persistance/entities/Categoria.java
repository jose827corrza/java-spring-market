package com.josedev.market.persistance.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String categoria;
    private Boolean estado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    // Relations
    @OneToMany(mappedBy = "categoria") //el atributo que sostiene eso y esta en esa clase
    private List<Producto> productos;
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
