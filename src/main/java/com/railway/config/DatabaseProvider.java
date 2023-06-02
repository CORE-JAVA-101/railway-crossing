package com.railway.config;

import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseProvider {

  private static final String JDBC_URL="jdbc:mysql://localhost:3306/railway";
  private static final String USERNAME="root";
  private static final String PASSWORD="";

  public static DataSource getDataSource() {

    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(JDBC_URL);
    config.setUsername(USERNAME);
    config.setDriverClassName(Driver.class.getName());
    config.setPassword(PASSWORD);

    return new HikariDataSource(config);
  }

  public static Connection getConnection() {
    try {
      Connection connection = getDataSource().getConnection();
      return connection;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void close(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void commit(Connection connection) {
    if (connection != null) {
      try {
        connection.commit();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
