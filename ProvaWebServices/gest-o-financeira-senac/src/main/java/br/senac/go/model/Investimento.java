package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data //faz os métodos get,set,tostring, hascode, equals
@Entity //fala para o ORM gerenciar o estado deste item no banco de dados
@Table(name = "INVESTIMENTO") //'nomea' a tabela do banco de dados
public class Investimento {

    @Id //fala que este item é chave primária
    @GeneratedValue(strategy= GenerationType.AUTO) //auto-incremental
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRICAO", length = 120, nullable = false)
    private String descricao;

    @Column(name = "VALOR_INICIAL", nullable = false)
    private BigDecimal valorInicial;

    @Column(name = "SALDO", nullable = false)
    private BigDecimal saldo;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    private List<TipoInvestimento> tipoInvestimentos = new ArrayList<>();
}
