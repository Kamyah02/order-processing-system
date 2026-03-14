
package com.example.ordersystem.service;

import com.example.ordersystem.entity.*;
import com.example.ordersystem.exception.BusinessException;
import com.example.ordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

 private final OrderRepository repository;

 public OrderServiceImpl(OrderRepository repository){
  this.repository = repository;
 }

 @Transactional
 public Order createOrder(Order order){
  order.setStatus(OrderStatus.PENDING);
  order.setCreatedAt(LocalDateTime.now());
  if(order.getItems()!=null){
   order.getItems().forEach(i -> i.setOrder(order));
  }
  return repository.save(order);
 }

 public Order getOrder(Long id){
  return repository.findById(id)
   .orElseThrow(() -> new BusinessException("Order not found"));
 }

 public List<Order> getOrders(OrderStatus status){
  if(status == null){
   return repository.findAll();
  }
  return repository.findByStatus(status);
 }

 public Order updateStatus(Long id, OrderStatus status){
  Order order = getOrder(id);
  order.setStatus(status);
  return repository.save(order);
 }

 public void cancelOrder(Long id){
  Order order = getOrder(id);

  if(order.getStatus()!=OrderStatus.PENDING){
   throw new BusinessException("Only PENDING orders can be cancelled");
  }

  order.setStatus(OrderStatus.CANCELLED);
  repository.save(order);
 }

}
