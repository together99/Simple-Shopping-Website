package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import po.Goods;


public class GoodsDao {

	// 创建一个数据库连接
    static Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    static PreparedStatement pstm = null;
     // 创建一个结果集对象
    static ResultSet rs = null;
    
	public static List<Goods> findAllGoods() {
		
		connection=DBConnection.getConnection();
	    List<Goods> list=new ArrayList<Goods>();
	    String sql = "select * from Goods where 1 = 1";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	Goods goods=new Goods();
            	goods.setId(rs.getInt(1));
            	goods.setName(rs.getNString(2));
            	goods.setCity(rs.getNString(3));
            	goods.setPrice(rs.getInt(4));
            	goods.setScoke(rs.getInt(5));
            	goods.setImages(rs.getBytes(6));
            	goods.setPicname(rs.getNString(7));
            	list.add(goods);
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return list;
	    
	}
	
	public static Goods findGoodsById(int id) {
		
		connection=DBConnection.getConnection();
	    Goods goods=new Goods();
	    String sql = "select * from Goods where id=?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	
            	goods.setId(rs.getInt(1));
            	goods.setName(rs.getNString(2));
            	goods.setCity(rs.getNString(3));
            	goods.setPrice(rs.getInt(4));
            	goods.setScoke(rs.getInt(5));
            	goods.setImages(rs.getBytes(6));
            	goods.setPicname(rs.getNString(7));
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return goods;
	    
	}
	
}
