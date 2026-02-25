package com.fatecgru.Projeto.Loja.de.Brinquedos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String nomeCategoria;

    @ManyToMany(mappedBy = "categorias") //foreign key basicamente
    private List<Jogo> jogos;
}
