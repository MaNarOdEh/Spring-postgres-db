package com.example.demo.deo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class UserDataAccess implements UserDeo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(UUID id, User user) {
        String sql = "INSERT INTO \"user\" (" + " id, " + " userName, " + " userPassword ) " + "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, user.getUserName(), user.getUserPassword());
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        String sql = "SELECT * FROM \"user\" WHERE id =?";
        User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserRowMapper());
        Optional<User> userOptional = Optional.of(user);
        return userOptional;
    }

    @Override
    public int deleteUser(UUID id) {
        String sql = "" + "DELETE FROM \"user\" " + "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateUser(UUID id, User user) {
        String sql = "" + "INSERT INTO \"user\" (" + " id, " + " userName, " + " userPassword) " + "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, user.getUserName(), user.getUserPassword());
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "SELECT id, username, userpassword FROM user";
        return null;
    }

}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setUserName(rs.getString("userName"));
        user.setUserPassword(rs.getString("userPassword"));

        return user;
    }

}
