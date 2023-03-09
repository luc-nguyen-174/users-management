package com.example.demo.service;

import com.example.demo.connection.ConnectionUsers;
import com.example.demo.model.Province;
import com.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.connection.ConnectionUsers.getConnection;

public class UserService implements IUser {
    private final String SELECT_ALL = "select * from users";
    private final String SELECT_BY_PROVINCE_ID = "select * from province where province_id = ?";


    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int p_id = resultSet.getInt("province_id");
                Province province = selectProvince(p_id);
                users.add(new User(id, name, province));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public Province selectProvince(int province_id) {
        Province province = null;
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_PROVINCE_ID);) {
            System.out.println(statement);
            statement.setInt(1, province_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String province_name = resultSet.getString("province_name");
                province = new Province(province_id, province_name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return province;
    }

}
