package ru.romasini.easy.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romasini.easy.shop.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
}
