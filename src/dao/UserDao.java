package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import po.User;

public class UserDao {
	// 创建一个数据库连接
    static Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    static PreparedStatement pstm = null;
     // 创建一个结果集对象
    static ResultSet rs = null;
    
	public List<User> selectAll() {
		
		connection=DBConnection.getConnection();
	    List<User> list=new ArrayList<User>();
	    String sql = "select * from Myuser where 1 = 1";
	    User user=new User();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	user.setUsername(rs.getNString(1));
            	user.setPassword(rs.getNString(3));
            	list.add(user);
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return list;
	    
	}
	
	
	public int selectOne(String username,String userpassword) {
		
		connection=DBConnection.getConnection();
	    
	    //User user=null;
		int stage=0;
	    String sql = "select * from Myuser where username=?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            //pstm.setString(2, userpassword);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	if(userpassword.equals(rs.getString(3)) ) {
            		stage=1;
            	}else {
            		stage=2;
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return stage;
	    
	}
	
	/*
	 * 修改
	 */
	
public int findUser(User user) {
		
		connection=DBConnection.getConnection();
	    
	    //User user=null;
		int stage=0;
	    String sql = "select * from Myuser where username=?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            //pstm.setString(2, userpassword);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	if(user.getPassword().equals(rs.getString(3)) ) {
            		stage=1;
            	}else {
            		stage=2;
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
        return stage;
	    
	}

public static int findUserId(String Username) {
	
	connection=DBConnection.getConnection();
    
    
	int id=1;
    String sql = "select * from Myuser where username=?";
    try {
    	
        pstm = connection.prepareStatement(sql);
        pstm.setString(1, Username);
        rs = pstm.executeQuery();
        while (rs.next()) {
        	id=rs.getInt(2);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    	DBConnection.ReleaseResource();
    }
    return id;
    
}
	
	/*
	 * 修改
	 */
	public int insertUser(User user) {
		int flag=0;
		int index=getNum()+1025;
		System.out.println("index: "+index);
		connection=DBConnection.getConnection();
		String sql = "insert into  Myuser values(?,?,?)";
		try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setInt(2,index);
            pstm.setString(3, user.getPassword());
           
            flag=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.ReleaseResource();
        }
		return flag;
	}
	
	public int getNum() {
		int size=0;
		connection=DBConnection.getConnection();
		String sql = "select * from  Myuser where 1 = 1";
    	
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
