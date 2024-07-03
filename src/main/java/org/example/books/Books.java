package org.example.books;

public class Books {
     package com.example.peliculas;

import com.fasterxml.jackson.annotation.JsonProperty;

    public class Pelicula {
        private int id;
        private String titulo;
        private String director;
        private int ano;
        private String genero;

        public Pelicula(@JsonProperty("id") int id,
                        @JsonProperty("titulo") String titulo,
                        @JsonProperty("director") String director,
                        @JsonProperty("ano") int ano,
                        @JsonProperty("genero") String genero) {
            this.id = id;
            this.titulo = titulo;
            this.director = director;
            this.ano = ano;
            this.genero = genero;
        }

        // Getters y setters
        public int getId() { return id; }
        public String getTitulo() { return titulo; }
        public String getDirector() { return director; }
        public int getAno() { return ano; }
        public String getGenero() { return genero; }

        public void setId(int id) { this.id = id; }
        public void setTitulo(String titulo) { this.titulo = titulo; }
        public void setDirector(String director) { this.director = director; }
        public void setAno(int ano) { this.ano = ano; }
        public void setGenero(String genero) { this.genero = genero; }
    }
}
