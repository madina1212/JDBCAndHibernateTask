package peaksoft.dao;

import org.hibernate.cfg.Configuration;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    public UserDaoJdbcImpl() {

    }
    @Override
    public void createUsersTable() {
        String query = "create table users(id serial primary key ," +
                "name varchar," +
                "last_name varchar," +
                "age smallint);";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is created on database!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void dropUsersTable() {
        String query = "drop table users;";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
            System.out.println("Table deleted on database!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users(" +
                "name,last_name,age)" +
                "values (?,?,?);";
        try (Connection connection = Util.connectionToDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println("Added");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        String query = "delete from users where id = ?;";
        try (Connection connection = Util.connectionToDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            System.out.println("Successfully deleted user by id!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()){
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }
    @Override
    public void cleanUsersTable() {
        String query = "truncate table users;";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is truncate on database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}