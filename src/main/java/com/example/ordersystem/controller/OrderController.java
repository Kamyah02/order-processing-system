
package com.example.ordersystem.controller;

import com.example.ordersystem.entity.*;
import com.example.ordersystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

 private final OrderService service;

 public OrderController(OrderService service){
  this.service = service;
 }

 @PostMapping
 public Order create(@RequestBody Order order){
  return service.createOrder(order);
 }

 @GetMapping("/{id}")
 public Order get(@PathVariable Long id){
  return service.getOrder(id);
 }

 @GetMapping
 public List<Order> list(@RequestParam(required=false) OrderStatus status){
  return service.getOrders(status);
 }

 @PutMapping("/{id}/status")
 public Order updateStatus(@PathVariable Long id, @RequestParam OrderStatus status){
  return service.updateStatus(id,status);
 }

 @DeleteMapping("/{id}/cancel")
 public void cancel(@PathVariable Long id){
  service.cancelOrder(id);
 }

}
