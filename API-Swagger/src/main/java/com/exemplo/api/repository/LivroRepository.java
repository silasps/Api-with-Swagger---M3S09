package com.exemplo.api.repository;

import com.exemplo.api.model.Livro;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LivroRepository {

    private int idCounter;
    private List<Livro> livros;
    public LivroRepository(){
        List<Livro> cadastrados = List.of(
                new Livro(++idCounter, "Clean Code", "987654321", 2013, "Autor Livro Clean Code"),
                new Livro(++idCounter, "Arquitetura Limpa", "123456789", 2015, "Autor Livro Arquitetura Limpa"),
                new Livro(++idCounter, "Use a cabeça, pense Java", "987654323", 2009, "Autor Outro Livro")
        );

        this.livros = new ArrayList<>(cadastrados);
    }

    public List<Livro> findAll() {
        List<Livro> copia = new ArrayList<>(livros);

        copia.sort(Comparator.comparing(Livro::getId)); // Verificador de livros

        return copia;
    }

}
