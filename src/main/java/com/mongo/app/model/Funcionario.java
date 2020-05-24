package com.mongo.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;


@Data
@Document // equivale a um @entity
public class Funcionario {

    @Id // equivale o @id
    private String codigo;
    private String nome;
    private Integer idade;
    private BigDecimal salario;

    @DBRef
    // equivale a uma anotação de relacioanamento,
    // ela pode ser usada para referenciar qualquer todas as formar de relacionamento
    private Funcionario chefe;
}


