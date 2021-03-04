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
    
    // ����һ�����ݿ�����
    static Connection connection = null;
    // ����Ԥ����������һ�㶼�������������Statement
    static PreparedStatement pstm = null;
     // ����һ�����������
    static ResultSet rs = null;
    
    
    public static Connection getConnection() {
    	try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("�ɹ��������ݿ�");
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
