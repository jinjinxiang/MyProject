package Pro.dao;

import Pro.pojo.Person;
import Pro.pojo.Tuser;
import Pro.util.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuserDao {
    public Tuser getTuser(Tuser tuser) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();

        Scanner aa = new Scanner(System.in);
        System.out.print("id:");
        String id = aa.nextLine();
        System.out.print("请输入准确的用户名:");
        String name = aa.nextLine();
        System.out.print("请输入密码:");
        String password = aa.nextLine();
        System.out.print("名称包含:");
        String username = aa.nextLine();
        System.out.print("管理员id:");
        String roleId = aa.nextLine();
        tuser = new Tuser();
        int a = 0;
        String t=null;
        int a4 = 0;
        String b=null;
        if (!"".equals(id) && id != null) {
            a = Integer.parseInt(id);
        }
        if (!"".equals(roleId) && roleId != null) {
            a4 = Integer.parseInt(roleId);
        }
        tuser.setId(a);
        tuser.setAccount(t);
        tuser.setPassword(password);
        tuser.setUsername(b);
        tuser.setRoleId(a4);
        System.out.println(tuser.getId());
        System.out.println(tuser.getAccount());
        System.out.println(tuser.getPassword());
        System.out.println(tuser.getUsername());
        System.out.println(tuser.getRoleId());
        String sql = "select * from t_user where 1=1 ";
        String sql0 = "select * from t_user where 1=0 ";
        String sql1= "id = '"+tuser.getId()+"'";
        String sql2= "account = '"+tuser.getAccount()+"'";
        String sql3= "password='"+tuser.getPassword()+"'";
        String sql4= "username='"+tuser.getUsername()+"'";
        String sql5= "role_id='"+tuser.getRoleId()+"'";
        String sql10 = "order by salary desc";
        String sql11 ="order by salary asc";
        Statement stat=conn.createStatement();
        List<Tuser> list=new ArrayList<Tuser>();
        System.out.println("选择条件 1.and 2.or");
        Scanner s1=new Scanner(System.in);
        int i=s1.nextInt();
        if(i==1) {
            System.out.println("是否排序(根据id) 1.是 2.不是");
            Scanner s2 = new Scanner(System.in);
            int i2 = s2.nextInt();
            if (i2 == 1) {
                System.out.println("1.降序 2.升序");
                Scanner s3 = new Scanner(System.in);
                int i3 = s3.nextInt();
                if (i3 == 1) {
                    if (tuser.getId() != 0) {
                        sql += "and id = '" + tuser.getId() + "'";
                    }
                    if (tuser.getAccount() != null) {
                        sql += "and account = '" + tuser.getAccount() + "'";
                    }
                    if (tuser.getPassword()!=null) {
                        sql += "and password='" + tuser.getPassword() + "'";
                        System.out.println(sql);
                    }
                    if (tuser.getUsername() != null) {
                        sql += "and username like '%"+tuser.getUsername()+"%'";
                        System.out.println(sql);
                    }
                    if (tuser.getRoleId() != 0) {
                        sql += "and role_id='" + tuser.getRoleId() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql + "order by id desc ");
                    List<Tuser> list2 = new ArrayList<Tuser>();
                    while (rs2.next()) {
                        tuser = new Tuser(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                        list.add(tuser);
                    }
                    for (Tuser tuser1 : list) {
                        System.out.println(tuser1.getId() + "-->" + tuser1.getAccount() + "-->" + tuser1.getPassword() + "-->" + tuser1.getUsername() + "-->" + tuser1.getRoleId());
                    }
                } else if (i3 == 2) {
                    if (tuser.getId() != 0) {
                        sql += " and id = '" + tuser.getId() + "'";
                    }
                    if (tuser.getAccount() != null) {
                        sql += "and account = '" + tuser.getAccount() + "'";
                    }
                    if (tuser.getPassword() != null) {
                        sql += "and password='" + tuser.getPassword() + "'";
                        System.out.println(sql);
                    }
                    if (tuser.getUsername() != null) {
                        sql += "and username like '%"+tuser.getUsername()+"%'";
                        System.out.println(sql);
                    }
                    if (tuser.getRoleId() != 0) {
                        sql += "and role_id='" + tuser.getRoleId() + "'";
                        System.out.println(sql);
                    }
                    ResultSet rs2 = stat.executeQuery(sql + "order by id asc");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        tuser = new Tuser(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                        list.add(tuser);
                    }
                    System.out.println("这是升序");
                    for (Tuser tuser1 : list) {
                        System.out.println(tuser1.getId() + "-->" + tuser1.getAccount() + "-->" + tuser1.getPassword() + "-->" + tuser1.getUsername() + "-->" + tuser1.getRoleId());
                    }
                }
            }
        }else if (i==2){
            System.out.println("是否排序 1.是 2.不是");
            Scanner s2 = new Scanner(System.in);
            int i2 = s2.nextInt();
            if (i2 == 1) {
                System.out.println("1.降序 2.升序");
                Scanner s3 = new Scanner(System.in);
                int i3 = s3.nextInt();
                if (i3 == 1) {
                    if (tuser.getId() != 0) {
                        sql0 += "or id = '" + tuser.getId() + "'";
                    }
                    if (tuser.getAccount() != null) {
                        sql0 += "or name = '" + tuser.getAccount() + "'";
                    }
                    if (tuser.getPassword() != null) {
                        sql0 += "or password='" + tuser.getPassword() + "'";
                    }
                    if (tuser.getUsername() != null) {
                        sql0 += "or username like '%"+tuser.getUsername()+"%'";
                    }
                    if (tuser.getRoleId() != 0) {
                        sql0 += "or role_id='" + tuser.getRoleId() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql0 + "order by id desc ");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        tuser = new Tuser(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                        list.add(tuser);
                    }
                    for (Tuser tuser1 : list) {
                        System.out.println(tuser1.getId() + "-->" + tuser1.getAccount() + "-->" + tuser1.getPassword() + "-->" + tuser1.getUsername() + "-->" + tuser1.getRoleId());
                    }
                } else if (i3 == 2) {
                    if (tuser.getId() != 0) {
                        sql += " or id = '" + tuser.getId() + "'";
                    }
                    if (tuser.getAccount() != null) {
                        sql += "or name = '" + tuser.getAccount() + "'";
                    }
                    if (tuser.getPassword() != null) {
                        sql += "or password='" + tuser.getPassword() + "'";
                        System.out.println(sql);
                    }
                    if (tuser.getUsername() !=null) {
                        sql += "or username like '%"+tuser.getUsername()+"%'";
                        System.out.println(sql);
                    }
                    if (tuser.getRoleId() != 0) {
                        sql += "or role_id='" + tuser.getRoleId() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql0 + "order by id asc");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        tuser = new Tuser(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
                        list.add(tuser);
                    }
                    System.out.println("这是升序");
                    for (Tuser tuser1 : list) {
                        System.out.println(tuser1.getId() + "-->" + tuser1.getAccount() + "-->" + tuser1.getPassword() + "-->" + tuser1.getUsername() + "-->" + tuser1.getRoleId());
                    }
                }
            }
        }
        return tuser;
    }
    public Tuser getTuserfor() throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from t_user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Tuser tuser = null;
        List<Tuser> list=new ArrayList<Tuser>();
        while (rs.next()) {
            tuser = new Tuser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            System.out.println(tuser);
            list.add(tuser);
        }
        for (Tuser tuser1:list) {
            System.out.println(tuser1.getId()+"-->"+tuser1.getAccount()+"-->"+tuser1.getPassword()+"-->"+tuser1.getUsername()+"-->"+tuser1.getRoleId());
        }
        return tuser;
    }

    public  int addAccount(Tuser tuser) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="insert into t_user values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,tuser.getId());
        ps.setString(2,tuser.getAccount());
        ps.setString(3,tuser.getPassword());
        ps.setString(4,tuser.getUsername());
        ps.setInt(5,tuser.getRoleId());
        int i=ps.executeUpdate();
        return i;
    }
    public  int updateTuser(Tuser tuser) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="update t_user set account=?,password=?, username=?,role_id=? where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,tuser.getAccount());
        ps.setString(2,tuser.getPassword());
        ps.setString(3,tuser.getUsername());
        ps.setInt(4,tuser.getRoleId());
        ps.setInt(5,tuser.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public Tuser getAccount(String username, String password) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="select * from t_user where account=? and password=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        Tuser tuser=null;
            while(rs.next()){
                tuser=new Tuser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
            }
        return tuser;
    }
    public  int deleteTuserdao(Tuser tuser) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="delete from t_user where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,tuser.getId());
        int i=ps.executeUpdate();
        return i;
    }
}
