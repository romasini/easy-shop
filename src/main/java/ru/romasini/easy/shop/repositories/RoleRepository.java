package ru.romasini.easy.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romasini.easy.shop.models.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByName(String name);
}
