package io.github.leandrocvt.repository;

import io.github.leandrocvt.domain.entities.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {

    private static String INSERT = "insert into client (name) values (?) ";
    private static String SELECT_ALL = "SELECT * FROM CLIENT";
    private static String UPDATE = "update client set name = ? where id = ? ";
    private static String DELETE = "delete from client where id = ? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClientModel save(ClientModel clientModel){
        jdbcTemplate.update(INSERT, new Object[]{clientModel.getName()} );
        return clientModel;
    }

    public ClientModel update(ClientModel clientModel){
        jdbcTemplate.update(UPDATE, new Object[]{
                clientModel.getName(), clientModel.getId()});
        return clientModel;
    }

    public void delete(ClientModel clientModel){
        delete(clientModel.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<ClientModel> findallName(String name){
        return jdbcTemplate.query(
                SELECT_ALL.concat(" where name like ? "),
                new Object[]{"%" + name + "%"},
                findClientMapper());
    }

    public List<ClientModel> allClients(){
        return jdbcTemplate.query(SELECT_ALL, findClientMapper());
    }

    private RowMapper<ClientModel> findClientMapper() {
        return new RowMapper<ClientModel>() {
            @Override
            public ClientModel mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("name");
                return new ClientModel(id, nome);
            }
        };
    }
}
