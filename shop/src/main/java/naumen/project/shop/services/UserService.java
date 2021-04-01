package naumen.project.shop.services;

import naumen.project.shop.models.User;
import naumen.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUser(String login) {
        return userRepository.findUserByLogin(login);
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findUserByLogin(user.getLogin());

        if (userFromDB != null)
            return false;

        userRepository.save(user);
        return true;
    }
}
