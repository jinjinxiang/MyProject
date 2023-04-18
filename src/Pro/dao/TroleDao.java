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

public class TroleDao {
    public Trole getTrole(String role) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from t_role where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, role);
        ResultSet rs = ps.executeQuery();
        Trole trole = null;
        while (rs.next()) {
            trole = new Trole(rs.getInt(1), rs.getString(2));
        }
        return trole;
    }
    public  int addAccount(Trole trole) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="insert into t_role values(?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,trole.getId());
        ps.setString(2,trole.getRole());
        int i=ps.executeUpdate();
        return i;
    }
    public  int updateTrole(Trole trole) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="update t_role set role=? where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,trole.getRole());
        ps.setInt(2,trole.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public  int deleteTrole(Trole trole) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="delete from t_role where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,trole.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public Trole getTrole(Trole trole) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();

        Scanner aa = new Scanner(System.in);
        System.out.print("id:");
        String id = aa.nextLine();
        Trole t= new Trole();
        int a = 0;
        int a2 = 0;

        if (!"".equals(id) && id != null) {
            a = Integer.parseInt(id);
        }
        t.setId(a);
        System.out.println(t.getId());
        System.out.println(t.getRole());
        String sql = "select * from t_role where id = '" + t.getId() + "'";
        String sql2 = "order by id desc";
        String sql3 = "order by id asc";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        System.out.println(sql+sql2);
        List<Trole> list=new ArrayList<Trole>();
        System.out.println("是否排序 1.是 2.不是");
        Scanner s1=new Scanner(System.in);
        int i=s1.nextInt();
        if(i==1){
            System.out.println("1.降序 2.升序");
            Scanner s2=new Scanner(System.in);
            int i2=s2.nextInt();
            if (i2==1){
                ResultSet rs2= stat.executeQuery(sql+sql2);
                List<Trole> list2=new ArrayList<Trole>();
                while (rs2.next()) {
                     trole= new Trole(rs2.getInt(1), rs2.getString(2));
                    list.add(trole);
                }
                System.out.println("这是根据id降序");
                for (Trole trole1:list) {
                    System.out.println(trole1.getId()+"-->"+trole1.getRole());
                }
            }
            if(i2==2){
                ResultSet rs2= stat.executeQuery(sql+sql3);
                List<Trole> list2=new ArrayList<Trole>();
                while (rs2.next()) {
                    trole = new Trole(rs2.getInt(1), rs2.getString(2));
                    list.add(trole);
                }
                System.out.println("这是根据id升序");
                for (Trole trole1:list) {
                    System.out.println(trole1.getId()+"-->"+trole1.getRole());
                }
            }
        }
        if(i==2){
            while (rs.next()) {
                trole = new Trole(rs.getInt(1), rs.getString(2));
                list.add(trole);
            }
            for (Trole trole1:list) {
                System.out.println(trole1.getId()+"-->"+trole1.getRole());
            }
        }
        return trole;
    }
    public Trole getTrolefor() throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from t_role";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Trole trole = null;
        List<Trole> list=new ArrayList<Trole>();
        while (rs.next()) {
            trole = new Trole(rs.getInt(1), rs.getString(2));
            System.out.println(trole);
            list.add(trole);
        }
        for (Trole trole1:list) {
            System.out.println(trole1.getId()+"-->"+trole1.getRole());
        }
        return trole;
    }
}
