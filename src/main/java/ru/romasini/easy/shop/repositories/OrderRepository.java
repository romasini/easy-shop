package ru.romasini.easy.shop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.romasini.easy.shop.models.Order;
import ru.romasini.easy.shop.models.User;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
   Page<Order> findAllByUser(User user, Pageable pageable);
}
