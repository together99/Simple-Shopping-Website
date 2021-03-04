package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static String USERNAMR = "system";
    private static String PASSWORD = "xuyuqing";
    private static String DRVIER = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@ 192.168.59.1:1521:xe";
    
    // 创建一个数据库连接
    static Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    static PreparedStatement pstm = null;
     // 创建一个结果集对象
    static ResultSet rs = null;
    
    
    public static Connection getConnection() {
    	try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not find !", e);
        } catch (SQLException e) {
            throw new RuntimeException("get connection error!", e);
        }

        return connection;
    }
    
    public static void ReleaseResource() {
    	if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
