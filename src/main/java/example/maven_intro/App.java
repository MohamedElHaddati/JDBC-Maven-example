package example.maven_intro;

import java.sql.*;

public class App {
   public static void main(String[] args) {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");

           String url = "jdbc:mysql://localhost:3306/tp_jdbc";
           String user = "root";
           String password = "";
           Connection conn = DriverManager.getConnection(url, user, password);

           String insertSql = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
           PreparedStatement insertStatement = conn.prepareStatement(insertSql);
           insertStatement.setString(1, "Rachid");
           insertStatement.setString(2, "Sghir");
           insertStatement.setInt(3, 12);
           int rowsInserted = insertStatement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("A new student was inserted successfully!");
           }
           String insertSql2 = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
           PreparedStatement insertStatement2 = conn.prepareStatement(insertSql2);
           insertStatement2.setString(1, "Mohamed");
           insertStatement2.setString(2, "Ali");
           insertStatement2.setInt(3, 37);
           int rowsInserted2 = insertStatement2.executeUpdate();
           if (rowsInserted2 > 0) {
              System.out.println("A new student was inserted successfully!");
           }

           String insertSql3 = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
           PreparedStatement insertStatement3 = conn.prepareStatement(insertSql3);
           insertStatement3.setString(1, "Fatima");
           insertStatement3.setString(2, "Zahra");
           insertStatement3.setInt(3, 15);
           int rowsInserted3 = insertStatement3.executeUpdate();
           if (rowsInserted3 > 0) {
              System.out.println("A new student was inserted successfully!");
           }
           
           String selectSql = "SELECT * FROM etudiants";
           Statement selectStatement = conn.createStatement();
           ResultSet result = selectStatement.executeQuery(selectSql);
           while (result.next()) {
              int id = result.getInt("id");
              String nom = result.getString("nom");
              String prenom = result.getString("prenom");
              int age = result.getInt("age");
              System.out.println("Student ID: " + id + ", name: " + nom + " " + prenom + ", age: " + age);
           }

           
           String updateSql = "UPDATE etudiants SET nom = ? WHERE nom = 'Belkadi'";
           PreparedStatement updateStatement = conn.prepareStatement(updateSql);
           updateStatement.setInt(1, 20);
           int rowsUpdated = updateStatement.executeUpdate();
           if (rowsUpdated > 0) {
             System.out.println("A student was updated successfully!");
           }
           
           String deleteSql = "DELETE FROM etudiants WHERE nom = ?";
           PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
           deleteStatement.setString(1, "Mohamed");
           int rowsDeleted = deleteStatement.executeUpdate();
           if (rowsDeleted > 0) {
              System.out.println("A student was deleted successfully!");
           }

           String updateSql1 = "UPDATE etudiants SET age = ? WHERE nom = ?";
           PreparedStatement updateStatement1 = conn.prepareStatement(updateSql1);
           updateStatement1.setInt(1, 16);
           updateStatement1.setString(2, "Fatima");
           int rowsUpdated1 = updateStatement1.executeUpdate();
           if (rowsUpdated1 > 0) {
              System.out.println("A student's age was updated successfully!");
           }



           String selectSql1 = "SELECT * FROM etudiants";
           Statement selectStatement1 = conn.createStatement();
           ResultSet result1 = selectStatement1.executeQuery(selectSql1);
           while (result1.next()) {
               int id = result1.getInt("id");
               String nom = result1.getString("nom");
               String prenom = result1.getString("prenom");
               int age = result1.getInt("age");
               System.out.println("Student ID: " + id + ", name: " + nom + " " + prenom + ", age: " + age);
           }

           conn.close();

       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
   }
}
