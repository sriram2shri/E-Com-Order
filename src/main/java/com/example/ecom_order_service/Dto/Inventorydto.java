package com.example.ecom_order_service.Dto;

public class Inventorydto {

    private Long productId;
    private int quantity;

    public Inventorydto() {
    }

    public Inventorydto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}