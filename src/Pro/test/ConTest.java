package Pro.test;

import Pro.dao.TuserDao;
import Pro.pack.Pack;
import Pro.pojo.Tuser;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConTest {
    public int test() {
        Pack p = new Pack();
        while (true) {
            System.out.println("请输入您要进行的操作:1.注册 2.登录 3.退出系统");
            try {
                Scanner s1 = new Scanner(System.in);
                int i = s1.nextInt();
                if (i == 1) {
                    //*****注册*****
                    p.save();

                } else if (i == 2) {
                    //*****登录*****
                    p.login();
                } else if (i == 3) {
                    System.exit(0);
                } else {
                    System.out.println("请输入正确的操作");
                }

            } catch (Exception e) {
                System.out.println("请输入正确的操作");
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        ConTest ct=new ConTest();
        ct.test();
    }
}
