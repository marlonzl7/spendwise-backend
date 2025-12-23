package com.spendwise.dao;

import com.spendwise.config.ConnectionFactory;
import com.spendwise.model.Spend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpendDAO {
    public void save(Spend spend){
        String sql = "INSERT INTO spends(date_spend, description_spend, category_spend, value_spend, type_spend) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setDate(1, Date.valueOf(spend.getDate()));
            preparedStatement.setString(2, spend.getDescription());
            preparedStatement.setString(3, spend.getCategory());
            preparedStatement.setBigDecimal(4, spend.getValue());
            preparedStatement.setString(5, spend.getType().name());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
