package com.fatecgru.Projeto.Loja.de.Brinquedos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idJogo;
    @NotNull
    private String nomeJogo;
    @NotNull
    private Double valor;
    @NotNull
    private String detalhes;
    @NotNull
    private String desenvolvedora;
    @NotNull
    private String imagem;

    //basicamente, não será necessário criar aqui a tabela Categoria_Jogo como uma classe, mas sim usar a anotação JoinTable
    // que o próprio JPA iria salvar no banco de dados
    @ManyToMany
    @JoinTable(name = "Categoria_Jogo", joinColumns = @JoinColumn(name = "idJogo"), inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    private List<Categoria> categorias;
}
