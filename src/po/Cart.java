package po;

import java.util.HashMap;

import po.Goods;

public class Cart {
	private HashMap<Goods, Integer> cgoods;
	private double totalPrice;
	public HashMap<Goods, Integer> getCGoods() {
		return cgoods;
	}
	public void setCGoods(HashMap<Goods, Integer> cgoods) {
		
	}
	public double getTotalPrice() {
		totalPrice=calPrice();
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		
	}
	
	public Cart() {
		this.cgoods = new HashMap<Goods, Integer>();
		this.totalPrice = 0;
	}
	public boolean addGoods(Goods goods,int num) {
		if(totalPrice > 0) {
			if(isHad(goods))
			num+=cgoods.get(goods);
		}
		
		
		cgoods.put(goods, num);
		totalPrice=calPrice();
		return true;
	}
	public boolean removeGoods(Goods goods) {
		cgoods.remove(goods);
		totalPrice=calPrice();
		return true;
	}
	public double calPrice() {
		double sum = 0;
		for(Goods key:cgoods.keySet()) {
			sum=sum+key.getPrice()*cgoods.get(key);
		}
		return sum;
	}
	public boolean isHad(Goods goods) {
		for(Goods key:cgoods.keySet()) {
			if(key.getId()==goods.getId()) {
				return true;
			}
		}
		return false;
	}
}

