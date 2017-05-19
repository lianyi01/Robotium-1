package Untils;

import java.sql.*;

import android.util.Log;
import redis.clients.jedis.Jedis;

public class DBUtils {
	/*
	 * redis
	 */
	public static String redisGetCode(String phone) {
		String code = null;
		if (null != phone && "" != phone && phone.length() == 11) {
			Jedis jedis = new Jedis("139.219.12.51", 30303);
			code = jedis.get(phone);
		}
		return code;
	}
	
	
	/**
     * Mysql
     **/
    // 驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名scutcs
    String url = "jdbc:mysql://xxx?useUnicode=true&characterEncoding=gbk";
    // MySQL配置时的用户名
    String user = "xxx";
    // MySQL配置时的密码
    String password = "xxx";
    public Connection conn;
    public Statement stmt;
    public ResultSet resultset = null;
    public void initMysql(){
    	try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            conn = DriverManager.getConnection(url, user, password);
            
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            
            stmt = conn.createStatement();
            
    	}catch(Exception e){
    		
    		Log.e("数据库连接错误:", e.getMessage().toString());
    	}
    }
    public void selectDB(String db){
    	if(db !=""){
            //执行sql
            try {
				stmt.execute(db);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.e("选择数据库错误:", e.getMessage().toString());
			}
    	}
    }
    public void SQLUpdate(String updatesql){
    	//插入数据
    	if(updatesql != ""){
			try {
				stmt.executeUpdate(updatesql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.e("数据库Update操作错误:", e.getMessage().toString());
			}
            
    	}
    }
    public ResultSet SQLQuery(String selectsql){
    	//查询数据
    	try {
			resultset = stmt.executeQuery(selectsql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Log.e("数据库Select操作错误:", e.getMessage().toString());
		}
    	
    	return resultset;
    }
    public  synchronized void close() {
    	//关闭连接
        try {
        	if (resultset != null){
        		resultset.close();
        		resultset = null;
        	}
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
        	Log.e("数据库关闭错误:", e.getMessage().toString());
        }
    }
}
