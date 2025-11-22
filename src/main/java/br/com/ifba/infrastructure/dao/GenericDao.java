/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastucture.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ETM-00168
 * 
 */
@Repository
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

@Autowired
private GenericDao<Curso> cursoDao;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Entity save(Entity obj) {
        entityManager.persist(obj);
        return obj;
    }

    @Override
    public Entity update(Entity obj) {
        return entityManager.merge(obj);
    }

    @Override
    public void delete(Entity obj) {
        Entity entityEncontrada = entityManager.merge(obj);
        entityManager.remove(entityEncontrada);
    }

    @Override
    public List<Entity> findAll() {
        return (List<Entity>) entityManager.createQuery("from " + getTypeClass().getName(), getTypeClass())
                            .getResultList();
    }

    @Override
    public Entity findByLd(Long id) {
         return (Entity) entityManager.find(getTypeClass(), id);
    }
      protected Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass()
                          .getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
}