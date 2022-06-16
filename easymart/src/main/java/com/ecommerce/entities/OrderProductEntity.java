package com.ecommerce.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.entities.pk.OrderProductEntityPK;

import lib.easymart.models.OrderProduct;

@Entity
@Table(name = "tb_pedido_produto")
public class OrderProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderProductEntityPK id = new OrderProductEntityPK();
	
	@Column(name = "quantidade")
	private Integer quantity;
	
	@Column(name = "preco")
	private BigDecimal price;
	
	public OrderProductEntity() {}

	public OrderProductEntity(OrderProduct model) {
		if(model != null && model.getOrder() != null && model.getProduct() != null) {
		}
	}
	
	public OrderProductEntity(OrderEntity order, ProductEntity product, Integer quantity, BigDecimal price) {
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	/*@JsonIgnore
	public OrderEntity getOrder() {
		return id.getOrder();
	}
	public void setOrder(OrderEntity order) {
		id.setOrder(order);
	}
	public ProductEntity getProduct() {
		return id.getProduct();
	}
	public void setProduct(ProductEntity product) {
		id.setProduct(product);
	}*/
	
	public OrderProductEntityPK getId() {
		return id;
	}
	public void setId(OrderProductEntityPK id) {
		this.id = id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductEntity other = (OrderProductEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public OrderProduct toModel() {
		OrderProduct model = new OrderProduct();
		
		/*model.setOrder(this.getOrder().toModel());
		model.setProduct(this.getProduct().toModel());*/
		model.setQuantity(this.quantity);
		model.setPrice(this.price);
		
		return model;
	}
}
