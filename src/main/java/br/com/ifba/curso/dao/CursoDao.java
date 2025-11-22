package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CursoDao() {
        super();
    }

    @Override
    @Transactional
    public Curso buscarPorCodigo(String codigo) {
        try {
            String jpql = "SELECT c FROM Curso c WHERE c.codigoCurso = :codigo";
            Curso curso = entityManager.createQuery(jpql, Curso.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
            return curso;
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao buscar curso por código: " + e.getMessage());
            return null;
        }
    }
}

