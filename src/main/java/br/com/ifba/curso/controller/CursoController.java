/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ETM-00168
 */
@Controller
public class CursoController implements CursoIController {

@Autowired
private CursoIService cursoIService;


@Override
public void save(Curso curso) {
    // Delegação da operação de salvar para o serviço real
    cursoIService.save(curso);
}

@Override
public void update(Curso curso) {
    // Delegação da operação de atualização para o serviço real
    cursoIService.update(curso);
}

@Override
public void delete(Curso curso) {
    // Delegação da operação de remoção para o serviço real
    cursoIService.delete(curso);
}

@Override
public List<Curso> findAll() {
    // Solicita ao serviço a lista completa de cursos
    return cursoIService.findAll();
}

@Override
public Curso findById(Long id) {
    // Busca um curso por ID através do serviço real
    return cursoIService.findById(id);
}

@Override
public List<Curso> findByCodigo(String codigo) {
    // Busca um curso pelo código e retorna uma lista
    return cursoIService.findByCodigo(codigo);
}

}
