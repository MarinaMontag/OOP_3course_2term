package service;

import dao.UserDAO;
import exception.ServerException;
import model.User;

public class UserServiceImpl implements UserService{
    @Override
    public User createUser(User user) throws ServerException, ClassNotFoundException {
        return UserDAO.addUser(user);
    }
}
