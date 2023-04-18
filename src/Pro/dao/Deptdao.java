package Pro.dao;

import Pro.pojo.Dept;
import Pro.pojo.Person;
import Pro.pojo.Trole;
import Pro.pojo.Tuser;
import Pro.util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deptdao {
    public  int addDept(Dept dept) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="insert into dept values(?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,dept.getId());
        ps.setString(2,dept.getDname());
        int i=ps.executeUpdate();
        return i;
    }
    public  int updateDept(Dept dept) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="update dept set dname=? where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,dept.getDname());
        ps.setInt(2,dept.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public  int deleteDept(Dept dept) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="delete from dept where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,dept.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public Dept getDept(Dept dept) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();

        Scanner aa = new Scanner(System.in);
        System.out.print("id:");
        String id = aa.nextLine();
        System.out.print("请输入部门");
        String name = aa.nextLine();
        Dept d= new Dept();
        int a = 0;
        int a2 = 0;

        if (!"".equals(id) && id != null) {
            a = Integer.parseInt(id);
        }
        d.setId(a);
        d.setDname(name);
        System.out.println(d.getId());
        System.out.println(d.getDname());
        String sql = "select * from dept where id = '" + d.getId() + "'or dname = '%" + d.getDname()+ "'";
        String sql2 = "order by id desc";
        String sql3 = "order by id asc";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        System.out.println(sql+sql2);
        List<Dept> list=new ArrayList<Dept>();
        System.out.println("是否排序 1.是 2.不是");
        Scanner s1=new Scanner(System.in);
        int i=s1.nextInt();
        if(i==1){
            System.out.println("1.降序 2.升序");
            Scanner s2=new Scanner(System.in);
            int i2=s2.nextInt();
            if (i2==1){
                ResultSet rs2= stat.executeQuery(sql+sql2);
                List<Dept> list2=new ArrayList<Dept>();
                while (rs2.next()) {
                    dept = new Dept(rs2.getInt(1), rs2.getString(2));
                    list.add(dept);
                }
                System.out.println("这是根据id降序");
                for (Dept dept1:list) {
                    System.out.println(dept1.getId()+"-->"+dept1.getDname());
                }
            }
            if(i2==2){
                ResultSet rs2= stat.executeQuery(sql+sql3);
                List<Tuser> list2=new ArrayList<Tuser>();
                while (rs2.next()) {
                    dept = new Dept(rs2.getInt(1), rs2.getString(2));
                    list.add(dept);
                }
                System.out.println("这是根据id升序");
                for (Dept dept2:list) {
                    System.out.println(dept2.getId()+"-->"+dept2.getDname());
                }
            }
        }
        if(i==2){
            while (rs.next()) {
                dept = new Dept(rs.getInt(1), rs.getString(2));
                list.add(dept);
            }
            for (Dept dept1:list) {
                System.out.println(dept1.getId()+"-->"+dept1.getDname());
            }
        }
        return dept;
    }
    public Dept getDeptfor() throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from dept";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Dept dept = null;
        List<Dept> list=new ArrayList<Dept>();
        while (rs.next()) {
            dept = new Dept(rs.getInt(1), rs.getString(2));
            System.out.println(dept);
            list.add(dept);
        }
        for (Dept dept1:list) {
            System.out.println(dept1.getId()+"-->"+dept1.getDname());
        }
        return dept;
    }
}
