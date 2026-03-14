
package com.example.ordersystem.repository;

import com.example.ordersystem.entity.Order;
import com.example.ordersystem.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
 List<Order> findByStatus(OrderStatus status);
}
