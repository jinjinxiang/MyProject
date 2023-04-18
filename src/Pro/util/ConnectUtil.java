package Pro.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static{
            Properties prop=new Properties();
        try {
            prop.load(new FileReader(new File("src/Pro/util/prop.properties")));
            driver=prop.getProperty("driverClassName");
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            password=prop.getProperty("password");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public void getClose(Connection con, Statement stat, ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
