
package com.example.ordersystem.service;

import com.example.ordersystem.entity.Order;
import com.example.ordersystem.entity.OrderStatus;
import java.util.List;

public interface OrderService {

 Order createOrder(Order order);
 Order getOrder(Long id);
 List<Order> getOrders(OrderStatus status);
 Order updateStatus(Long id, OrderStatus status);
 void cancelOrder(Long id);

}
