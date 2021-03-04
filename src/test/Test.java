package test;

import java.util.List;

import dao.GoodsDao;
import dao.OrdersDao;
import po.Goods;
import po.Orders;
import po.OrdersItem;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Goods goods=GoodsDao.findGoodsById(4);
		OrdersItem item=new OrdersItem();
		item.setGoods(goods);
		item.setItemId(1);
		item.setNum(2);
		item.setTotalPrice(100);
		System.out.println(item.getGoods().getId());
		System.out.println(item.getNum());
		Orders order=new Orders();
		order.setItems(item);
		order.setOrderNum(10001);
		order.setOrdersId(1);
		order.setState("fahuo");
		
		//OrdersDao.addOrder(item, 1001, "fahuo");
		List<Orders> oList= OrdersDao.findOrdersById(1001);
		for(Orders o:oList) {
			System.out.println(o.getState());
			System.out.println(o.getOrderNum());
			System.out.println(o.getItems().getItemId());
		}
	}

}
