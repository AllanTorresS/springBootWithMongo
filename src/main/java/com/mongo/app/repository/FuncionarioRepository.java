package com.mongo.app.repository;

import com.mongo.app.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * no mongo db vc não precisa por default definir nada
 * sobre o banco no .properties, o spring boot automaticamente vai
 * criar um banco.
 */
@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    @Query("{ $and: [ { 'idade': { $gt : ?0 }}, { 'idade': {$lt : ?1} } ] }")
    public List<Funcionario> obterFuncionarioPorIdade(Integer de, Integer ate);

    public List<Funcionario> findByNome();
}
