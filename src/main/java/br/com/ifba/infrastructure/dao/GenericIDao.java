/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastucture.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author ETM-00168
 */
public interface GenericIDao<Entity extends PersistenceEntity> {
    
    // metodos basicos 
  public abstract Entity save(Entity obj);
  public abstract Entity update(Entity obj);
  public abstract void delete(Entity obj);
  public abstract List<Entity> findAll();
  public abstract Entity findByLd(Long id);
    
}
