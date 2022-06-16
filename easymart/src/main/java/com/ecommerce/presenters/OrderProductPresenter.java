package com.ecommerce.presenters;

import java.math.BigDecimal;

import lib.easymart.models.OrderProduct;

public class OrderProductPresenter {

	private OrderPresenter order;
	private ProductPresenter product;
	private Integer quantity;
	private BigDecimal price;
	
	public OrderProductPresenter (OrderProduct model) {
		this.order = new OrderPresenter(model.getOrder());
		this.product = new ProductPresenter(model.getProduct());
		this.quantity = model.getQuantity();
		this.price = model.getPrice();
	}

	public OrderPresenter getOrder() {
		return order;
	}

	public ProductPresenter getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
}
