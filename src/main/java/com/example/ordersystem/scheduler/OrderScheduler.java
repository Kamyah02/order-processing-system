
package com.example.ordersystem.scheduler;

import com.example.ordersystem.entity.OrderStatus;
import com.example.ordersystem.repository.OrderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderScheduler {

 private final OrderRepository repository;

 public OrderScheduler(OrderRepository repository){
  this.repository = repository;
 }

 @Scheduled(fixedRate = 300000)
 public void processPendingOrders(){

  repository.findByStatus(OrderStatus.PENDING)
   .forEach(order -> {
    order.setStatus(OrderStatus.PROCESSING);
    repository.save(order);
   });

 }

}
