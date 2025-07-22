package com.giodad.progetto_libreria.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Il titolo non può essere in bianco")
    @Size(min=3 , max=100 , message = "Lunghezza minima di 3 e lunghezza massima di 100")
    private String titolo;
    @NotBlank(message = "L'autore non può essere in bianco")
    @Size(min=3 , max=100 , message = "Lunghezza minima di 3 e lunghezza massima di 100")
    private String Autore;
    @NotNull(message = "Il prezzo non può essere in bianco")
    private Double prezzo;
    
    Libro(String titolo,String Autore, Double prezzo)
    {
      this.titolo= titolo;
      this.Autore= Autore;
      this.prezzo= prezzo;  
    }

}
