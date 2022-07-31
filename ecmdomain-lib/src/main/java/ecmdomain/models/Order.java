package ecmdomain.models;

import java.time.Instant;
import java.util.Set;

public class Order {

	private Long id;
	private Instant moment;
	private User userClient;
	//private Set<OrderProduct> orderProducts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public User getUserClient() {
		return userClient;
	}
	public void setUserClient(User userClient) {
		this.userClient = userClient;
	}
//	public Set<OrderProduct> getOrderProducts() {
//		return orderProducts;
//	}
//	public void setOrderProducts(Set<OrderProduct> orderProducts) {
//		this.orderProducts = orderProducts;
//	}
		
}
