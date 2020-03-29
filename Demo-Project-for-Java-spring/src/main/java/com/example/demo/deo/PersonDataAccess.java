package com.example.demo.deo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccess implements UserDeo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(UUID id, Person user) {
        String sql = "INSERT INTO \"user\" (" + " id, " + " userName, " + " userPassword ) " + "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, user.getUserName(), user.getUserPassword());
    }

    @Override
    public Optional<Person> selectUserById(UUID id) {
        String sql = "SELECT * FROM \"user\" WHERE id =?";
        Person user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserRowMapper());
        Optional<Person> userOptional = Optional.of(user);
        return userOptional;
    }

    @Override
    public int deleteUser(UUID id) {
        String sql = "" + "DELETE FROM \"user\" " + "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateUser(UUID id, Person user) {
        String sql = "" + "INSERT INTO \"user\" (" + " id, " + " userName, " + " userPassword) " + "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, user.getUserName(), user.getUserPassword());
    }

    @Override
    public List<Person> selectAllUsers() {
        String sql = "SELECT id, username, userpassword FROM user";
        return null;
    }

}

class UserRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person user = new Person();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setUserName(rs.getString("userName"));
        user.setUserPassword(rs.getString("userPassword"));

        return user;
    }

}
