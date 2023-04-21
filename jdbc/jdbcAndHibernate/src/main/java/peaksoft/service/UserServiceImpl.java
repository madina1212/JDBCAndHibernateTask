package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJdbcImpl userDao = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDao.createUsersTable();

    }

    public void dropUsersTable() {
        userDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userDao.getAllUsers();
        return users;
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
