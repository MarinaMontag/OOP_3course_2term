package service;

import exception.ServerException;
import model.User;

public interface UserService {
   User createUser(User user) throws ServerException, ClassNotFoundException;
}
