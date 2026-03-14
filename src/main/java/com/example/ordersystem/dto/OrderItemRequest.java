
package com.example.ordersystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderItemRequest {

 @NotBlank
 private String productName;

 @Min(1)
 private int quantity;

 @Min(1)
 private double price;

 public String getProductName(){ return productName; }
 public void setProductName(String productName){ this.productName = productName; }

 public int getQuantity(){ return quantity; }
 public void setQuantity(int quantity){ this.quantity = quantity; }

 public double getPrice(){ return price; }
 public void setPrice(double price){ this.price = price; }
}
