package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Role;
import ru.romasini.easy.shop.repositories.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

}
