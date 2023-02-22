package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public ClientModel save(ClientModel clientModel){
        entityManager.persist(clientModel);
        return clientModel;
    }

    @Transactional
    public ClientModel update(ClientModel clientModel){
        entityManager.merge(clientModel);
        return clientModel;
    }

    @Transactional
    public void delete(ClientModel clientModel){
        if (!entityManager.contains(clientModel)){
            clientModel = entityManager.merge(clientModel);
        }
        entityManager.remove(clientModel);
    }

    @Transactional
    public void delete(Integer id){
        ClientModel clientModel = entityManager.find( ClientModel.class, id );
        delete(clientModel);
    }

    @Transactional(readOnly = true)
    public List<ClientModel> findallName(String name){
        String jpql = " select c from ClientModel c where c.name like :name ";
        TypedQuery<ClientModel> query = entityManager.createQuery(jpql, ClientModel.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<ClientModel> allClients(){
        return entityManager.createQuery("from ClientModel  ", ClientModel.class).getResultList();
    }

}
