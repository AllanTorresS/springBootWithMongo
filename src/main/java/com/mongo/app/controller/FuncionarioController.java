package com.mongo.app.controller;

import com.mongo.app.model.Funcionario;
import com.mongo.app.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
       return  this.funcionarioService.obterPorCodigo(codigo);
    }

    @GetMapping("/filtro")
    public List<Funcionario>obterFuncionarioPorIdade(@RequestParam Integer de, @RequestParam Integer ate){
        return this.funcionarioService.obterFuncionarioPorIdade(de,ate);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.criar(funcionario);
    }
}
