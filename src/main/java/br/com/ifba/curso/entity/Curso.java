/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;


import br.com.ifba.infrastucture.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ETM-00168
 */
@Entity
@Table(name = "curso")
public class Curso extends PersistenceEntity implements Serializable{
    
    // Coluna codigo
    @Column (name = "codigo", nullable = false, unique = true)
    private String codigo;
    
    // Coluna nome
    @Column (name = "nome", nullable = false)
    private String nome;
    
    // Coluna carga horaria
    @Column (name = "carga_horaria", nullable = false)
    private int cargaHoraria;

    // Coluna ativo
    @Column (name = "ativo")
    private boolean ativo;
    
    //metodos especiais
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
