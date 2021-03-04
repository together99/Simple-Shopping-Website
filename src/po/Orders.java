package po;

public class Orders {
	private int OrdersId;
	private int OrderNum;
	private String state;
	private OrdersItem items = new OrdersItem();
	private User user;
	public int getOrdersId() {
		return OrdersId;
	}
	public void setOrdersId(int ordersId) {
		OrdersId = ordersId;
	}
	public int getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public OrdersItem getItems() {
		return items;
	}
	public void setItems(OrdersItem items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
