package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import po.Goods;
import po.Orders;
import po.OrdersItem;

public class OrdersDao {
	// 创建一个数据库连接
    static Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    static PreparedStatement pstm = null;
     // 创建一个结果集对象
    static ResultSet rs = null;
    static ResultSet rs2 = null;
    
    public static void addOrder(OrdersItem items, int userId,String state) {
    	int flag=0;
		int ordersId=getOrdersNum()+1;
		int itemsId=getItemsNum()+1;
		int num=ordersId+1496;
		connection=DBConnection.getConnection();
		
		String sql = "insert into  Orders values(?,?,?,?,?)";
		String sql2 = "insert into  OrdersItem values(?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql2);
			if(items != null) {
				pstm.setInt(1, itemsId);
				pstm.setInt(2, items.getGoods().getId());
				pstm.setInt(3, items.getNum());
				pstm.setFloat(4, items.getTotalPrice());
				flag=pstm.executeUpdate();
				System.out.println("flag1="+flag);
			}
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, ordersId);
			pstm.setInt(2, num);
			pstm.setInt(3, itemsId);
			pstm.setInt(4, userId);
			pstm.setString(5, state);
			flag=pstm.executeUpdate();
			System.out.println("flag2="+flag);
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
		
	}
    
public static List<Orders> findOrdersById(int userId) {
		
		connection=DBConnection.getConnection();
	    List<Orders> orders=new ArrayList<Orders>();
	    
	    String sql = "select * from Orders where userId = "+userId;
        try {
            pstm = connection.prepareStatement(sql);
            rs2 = pstm.executeQuery();
            while (rs2.next()) {
            	
            	Orders order=new Orders();
            	
            	order.setOrdersId(rs2.getInt(1));
            	order.setOrderNum(rs2.getInt(2));
            	order.setItems(findItemById(rs2.getInt(3)));
            	order.setState(rs2.getString(5));
            	orders.add(order);
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return orders;
	    
	}
    
	public static OrdersItem findItemById(int itemId) {
		connection=DBConnection.getConnection();
	    String sql = "select * from OrdersItem where itemId="+itemId;
	    OrdersItem item=new OrdersItem();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
            	int goodsId=rs.getInt(2);
            	Goods goods=GoodsDao.findGoodsById(goodsId);
            	item.setItemId(rs.getInt(1));
            	item.setGoods(goods);
            	item.setNum(rs.getInt(3));
            	item.setTotalPrice(rs.getFloat(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return item;
	}

    public static int getOrdersNum() {
		int size=0;
		connection=DBConnection.getConnection();
		String sql = "select * from  Orders where 1 = 1";
    	
    	try {
    		pstm = connection.prepareStatement(sql);
    		//pstm.setString(1, tableName);
    		rs = pstm.executeQuery();
    		while (rs.next()) {
				size++;
				
			} 
       	
       }catch(SQLException e) {
       	e.printStackTrace();
       	
       }finally {
    	   DBConnection.ReleaseResource();
       }
    	return size;
	}
    public static int getItemsNum() {
		int size=0;
		connection=DBConnection.getConnection();
		String sql = "select * from  OrdersItem where 1 = 1";
    	
    	try {
    		pstm = connection.prepareStatement(sql);
    		//pstm.setString(1, tableName);
    		rs = pstm.executeQuery();
    		while (rs.next()) {
				size++;
			} 
       	
       }catch(SQLException e) {
       	e.printStackTrace();
       	
       }finally {
    	   DBConnection.ReleaseResource();
       }
    	return size;
	}
}
