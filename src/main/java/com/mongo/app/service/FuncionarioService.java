package com.mongo.app.service;

import com.mongo.app.model.Funcionario;
import com.mongo.app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> obterTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario obterPorCodigo(String codigo) {
        return funcionarioRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Funcionario não existe"));
    }

    public List<Funcionario> obterFuncionarioPorIdade(Integer de, Integer ate) {
        return this.funcionarioRepository.obterFuncionarioPorIdade(de, ate);
    }

    public Funcionario criar(Funcionario funcionario) {

        this.funcionarioRepository.findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe não encontradp"));

        return this.funcionarioRepository.save(funcionario);
    }
}
