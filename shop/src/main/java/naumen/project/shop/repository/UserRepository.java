package naumen.project.shop.repository;

import naumen.project.shop.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
}
