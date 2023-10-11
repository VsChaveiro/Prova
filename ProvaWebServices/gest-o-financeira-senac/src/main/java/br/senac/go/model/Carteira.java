package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data //faz os métodos get,set,tostring, hascode, equals
@Entity //fala para o ORM gerenciar o estado deste item no banco de dados
@Table(name = "CARTEIRA") //'nomea' a tabela do banco de dados
public class Carteira {

    @Id //fala que este item é chave primária
    @GeneratedValue(strategy= GenerationType.AUTO) //auto-incremental
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME", length = 120, nullable = false) //nomea o nome da coluna para MAIÚSCULO
    private String nome;

    @Column(name = "DESCRICAO", length = 120, nullable = false) //nomea o nome da coluna para MAIÚSCULO
    private String descricao;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    private List<Pessoa> pessoas = new ArrayList<>();
}
