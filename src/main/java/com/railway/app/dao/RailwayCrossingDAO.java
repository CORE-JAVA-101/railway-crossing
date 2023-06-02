package com.railway.app.dao;

import com.railway.app.model.RailwayCrossing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RailwayCrossingDAO {

   private Connection connection;
   
   public RailwayCrossingDAO(Connection connection) {
      this.connection = connection;
   }

   public boolean insertRailwayCrossing(RailwayCrossing crossing) {
      String query = "INSERT INTO railway_crossings (name, address, landmark, train_schedule, platform_in_charge, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
      
      try (PreparedStatement statement = connection.prepareStatement(query)) {
         statement.setString(1, crossing.getName());
         statement.setString(2, crossing.getAddress());
         statement.setString(3, crossing.getLandmark());
         statement.setTimestamp(4, Timestamp.valueOf(crossing.getTrainSchedule()));
         statement.setString(5, crossing.getPlatformInCharge());
         statement.setString(6, crossing.getStatus());
         
         int rowsAffected = statement.executeUpdate();
         return rowsAffected > 0;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return false;
   }


   public List<RailwayCrossing> getAllRailwayCrossings() {
      List<RailwayCrossing> crossings = new ArrayList<>();
      String query = "SELECT * FROM railway_crossings";

      try (PreparedStatement statement = connection.prepareStatement(query);
           ResultSet resultSet = statement.executeQuery()) {

         while (resultSet.next()) {
            RailwayCrossing crossing = new RailwayCrossing();
            crossing.setId(resultSet.getInt("id"));
            crossing.setName(resultSet.getString("name"));
            crossing.setAddress(resultSet.getString("address"));
            crossing.setLandmark(resultSet.getString("landmark"));
            crossing.setTrainSchedule(resultSet.getTimestamp("train_schedule").toLocalDateTime());
            crossing.setPlatformInCharge(resultSet.getString("platform_in_charge"));
            crossing.setStatus(resultSet.getString("status"));

            crossings.add(crossing);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return crossings;
   }

   public void deleteRailwayCrossing(int id) {
      PreparedStatement statement = null;

      try {
         String query = "DELETE FROM railway_crossings WHERE id = ?";
         statement = connection.prepareStatement(query);
         statement.setInt(1, id);
         statement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {

      }
   }
}
