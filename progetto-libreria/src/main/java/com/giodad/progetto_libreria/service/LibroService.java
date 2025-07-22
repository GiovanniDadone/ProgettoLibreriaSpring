package com.giodad.progetto_libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giodad.progetto_libreria.model.Libro;
import com.giodad.progetto_libreria.repository.LibroRepository;

@Service
public class LibroService {
    private final LibroRepository repo;

    @Autowired
    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public List<Libro> getLibreria() {
        List<Libro> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
    }

    public Optional<Libro> getById(Long id) {
        return repo.findById(id);
    }

    public Libro create(Libro nuovo) {
        repo.save(nuovo);
        return nuovo;
    }

    public Optional<Libro> update(Long id, Libro modificato) {
        return repo.findById(id).map(l -> {
            l.setTitolo(modificato.getTitolo());
            l.setAutore(modificato.getAutore());
            l.setPrezzo(modificato.getPrezzo());
            return repo.save(l);
        });
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
