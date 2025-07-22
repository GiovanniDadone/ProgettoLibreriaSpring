package com.giodad.progetto_libreria.repository;

import org.springframework.data.repository.CrudRepository;

import com.giodad.progetto_libreria.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {
    //tutti i metodi necessari già creati

}
