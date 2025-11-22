/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;


import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author ETM-00168
 */
@Service
public class CursoService implements CursoIService {
    
    @Autowired
    private CursoIDao cursoIDao;
    

@Override
public void save(Curso curso) throws IllegalArgumentException {

    // Validação: objeto não pode ser nulo
    if (curso == null) {
        throw new IllegalArgumentException("Dados do curso não podem ser nulos");
    }

    // Valida campos obrigatórios
    if (StringUtil.isNullOrEmpty(curso.getNome())) {
        throw new IllegalArgumentException("O nome do Curso é obrigatorio");
    }

    if (StringUtil.isNullOrEmpty(curso.getCodigo())) {
        throw new IllegalArgumentException("O Codigo do Curso é obrigatorio");
    }

    // Normaliza os textos (remove espaços extras)
    curso.setNome(StringUtil.normalize(curso.getNome()));
    curso.setCodigo(StringUtil.normalize(curso.getCodigo()));

    // Persiste o curso no banco de dados
    cursoIDao.save(curso);
}

@Override
public void update(Curso curso) throws IllegalArgumentException {

    // Validação de objeto nulo e ID inválido
    
    if (curso == null || curso.getId() <= 0) {
        throw new IllegalArgumentException("Impossivel atualizar um curso com o Id invalido");
    }

    // Validação redundante; mantém a segurança
    if (curso.getId() <= 0) {
        throw new IllegalArgumentException("Não é Possivel atualizar um curso com Id invalido");
    }

    // Valida campos obrigatórios
    if (StringUtil.isNullOrEmpty(curso.getNome())) {
        throw new IllegalArgumentException("Nome do Curso é obrigatorio");
    }

    if (StringUtil.isNullOrEmpty(curso.getCodigo())) {
        throw new IllegalArgumentException("Codigo do Curso é obrigatório");
    }

    // Normalização de texto
    curso.setNome(StringUtil.normalize(curso.getNome()));
    curso.setCodigo(StringUtil.normalize(curso.getCodigo()));

    // Atualiza o curso no banco
    cursoIDao.update(curso);
}

@Override
public void delete(Curso curso) throws IllegalArgumentException {

    // Não permite excluir um objeto inexistente
    if (curso == null) {
        throw new IllegalArgumentException("Dados do curso não preenchidos");
    } else {
        cursoIDao.delete(curso);
    }
}

@Override
public List<Curso> findAll() {
    // Retorna todos os cursos cadastrados
    return cursoIDao.findAll();
}

@Override
public Curso findById(Long id) throws IllegalArgumentException {

    // Validação de ID nulo ou inválido
    if (id == null || id <= 0) {
        throw new IllegalArgumentException("Id invalido para fazer a busca!");
    }

    // Busca por ID
    return cursoIDao.findByLd(id);
}

@Override
public List<Curso> findByCodigo(String codigo) throws RuntimeException {

    // Busca curso pelo código
    Curso curso = cursoIDao.buscarPorCodigo(codigo);

    // Se encontrou, retorna em uma lista
    if (curso != null) {
        return List.of(curso);
    }

    // Se não encontrou, retorna lista vazia
    return List.of();
}

    
}
