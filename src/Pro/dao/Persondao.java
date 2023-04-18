package Pro.dao;

import Pro.pojo.Person;
import Pro.pojo.Trole;
import Pro.pojo.Tuser;
import Pro.util.ConnectUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persondao {
    public Person getPersonfor(Person person) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();

        Scanner aa=new Scanner(System.in);
        System.out.print("id:");
        String id=aa.nextLine();
        System.out.print("名字包含:");
        String name=aa.nextLine();
        System.out.print("性别:");
        String sex=aa.nextLine();
        System.out.print("部门编号:");
        String dept_id=aa.nextLine();
        System.out.print("准确工资:");
        String salary=aa.nextLine();
        System.out.print("最大工资:");
        String salary2=aa.nextLine();
        System.out.print("最小工资:");
        String salary3=aa.nextLine();
        person=new Person();
        int a=0;
        int a2=0;
        int a3=0;
        int a4=0;
        int a5=0;
        int a6=0;
        String a7=null;
        if(!"".equals(id)&&id!=null){
            a=Integer.parseInt(id);
        }
        if(!"".equals(sex)&&sex!=null){
            a2=Integer.parseInt(sex);
        }
        if(!"".equals(dept_id)&&dept_id!=null){
            a3=Integer.parseInt(dept_id);
        }
        if(!"".equals(salary)&&salary!=null){
            a4=Integer.parseInt(salary);
        }
        if(!"".equals(salary2)&&salary2!=null){
            a5=Integer.parseInt(salary2);
        }
        if(!"".equals(salary3)&&salary3!=null){
            a6=Integer.parseInt(salary3);
        }
        if(!"".equals(name)&&name!=null){
            a7=name;
        }
        person.setId(a);
        person.setName(a7);
        person.setSex(a2);
        person.setDeptId(a3);
        person.setSalary(a4);
        person.setSalary2(a5);
        person.setSalary3(a6);
        String sql = "select * from person where 1=1 ";
        String sql0 = "select * from person where 1=0 ";
        String sql1= "id = '"+person.getId()+"'";
        String sql2= "name like '%"+person.getName()+"%'";
        String sql3= "sex='"+person.getSex()+"'";
        String sql4= "dept_id='"+person.getDeptId()+"'";
        String sql5= "salary='"+person.getSalary()+"'";
        String sql6= "salary<'"+person.getSalary2()+"'";
        String sql7= "salary>'"+person.getSalary3()+"'";
        String sql10 = "order by salary desc";
        String sql11 ="order by salary asc";
        Statement stat=conn.createStatement();
        List<Person> list=new ArrayList<Person>();
        System.out.println("选择条件 1.and 2.or");
        Scanner s1=new Scanner(System.in);
        int i=s1.nextInt();
        if(i==1) {
            System.out.println("是否按照工资排序 1.是 2.不是");
            Scanner s2 = new Scanner(System.in);
            int i2 = s2.nextInt();
            if (i2 == 1) {
                System.out.println("1.降序 2.升序");
                Scanner s3 = new Scanner(System.in);
                int i3 = s3.nextInt();
                if (i3 == 1) {
                    if (person.getId() != 0) {
                        sql += " and id = '" + person.getId() + "'";
                    }
                    if (person.getName() != null) {
                        sql += "and name like '%" + person.getName() + "%'";
                    }
                    if (person.getSex() != 0) {
                        sql += "and sex='" + person.getSex() + "'";
                        System.out.println(sql);
                    }
                    if (person.getDeptId() != 0) {
                        sql += "and dept_id='" + person.getDeptId() + "'";
                        System.out.println(sql);
                    }
                    if (person.getSalary() != 0) {
                        sql += "and salary='" + person.getSalary() + "'";
                    }
                    if (person.getSalary2() != 0) {
                        sql += "and salary='" + person.getSalary2() + "'";
                    }
                    if (person.getSalary3() != 0) {
                        sql += "and salary='" + person.getSalary3() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql + "order by salary desc ");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        person = new Person(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                        list.add(person);
                    }
                    for (Person person1 : list) {
                        System.out.println(person1.getId() + "-->" + person1.getName() + "-->" + person1.getSex() + "-->" + person1.getDeptId() + "-->" + person1.getSalary());
                    }
                } else if (i3 == 2) {
                    if (person.getId() != 0) {
                        sql += " and id = '" + person.getId() + "'";
                    }
                    if (person.getName() != null) {
                        sql += "and name like '%" + person.getName() + "%'";
                    }
                    if (person.getSex() != 0) {
                        sql += "and sex='" + person.getSex() + "'";
                        System.out.println(sql);
                    }
                    if (person.getDeptId() != 0) {
                        sql += "and dept_id='" + person.getDeptId() + "'";
                        System.out.println(sql);
                    }
                    if (person.getSalary() != 0) {
                        sql += "and salary='" + person.getSalary() + "'";
                    }
                    if (person.getSalary2() != 0) {
                        sql += "and salary='" + person.getSalary2() + "'";
                    }
                    if (person.getSalary3() != 0) {
                        sql += "and salary='" + person.getSalary3() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql + "order by salary asc");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        person = new Person(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                        list.add(person);
                    }
                    System.out.println("这是升序");
                    for (Person person1 : list) {
                        System.out.println(person1.getId() + "-->" + person1.getName() + "-->" + person1.getSex() + "-->" + person1.getDeptId() + "-->" + person1.getSalary());
                    }
                }
            }
        }else if (i==2) {
            System.out.println("是否按照工资排序 1.是 2.不是");
            Scanner s2 = new Scanner(System.in);
            int i2 = s2.nextInt();
            if (i2 == 1) {
                System.out.println("1.降序 2.升序");
                Scanner s3 = new Scanner(System.in);
                int i3 = s3.nextInt();
                if (i3 == 1) {
                    if (person.getId() != 0) {
                        sql0 += "or id = '" + person.getId() + "'";
                    }
                    if (person.getName() != null) {
                        sql0 += "or name like '%" + person.getName() + "%'";
                        System.out.println(sql0);
                    }
                    if (person.getSex() != 0) {
                        sql0 += "or sex='" + person.getSex() + "'";
                    }
                    if (person.getDeptId() != 0) {
                        sql0 += "or dept_id='" + person.getDeptId() + "'";
                    }
                    if (person.getSalary() != 0) {
                        sql0 += "or salary='" + person.getSalary() + "'";
                    }
                    if (person.getSalary2() != 0) {
                        sql0 += "or salary='" + person.getSalary2() + "'";
                    }
                    if (person.getSalary3() != 0) {
                        sql0 += "or salary='" + person.getSalary3() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql0 + "order by salary desc ");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        person = new Person(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                        list.add(person);
                    }
                    for (Person person1 : list) {
                        System.out.println(person1.getId() + "-->" + person1.getName() + "-->" + person1.getSex() + "-->" + person1.getDeptId() + "-->" + person1.getSalary());
                    }
                } else if (i3 == 2) {
                    if (person.getId() != 0) {
                        sql0 += " or id = '" + person.getId() + "'";
                    }
                    if (person.getName() != null) {
                        sql0 += "or name like '%" + person.getName() + "%'";
                    }
                    if (person.getSex() != 0) {
                        sql0 += "or sex='" + person.getSex() + "'";
                        System.out.println(sql);
                    }
                    if (person.getDeptId() != 0) {
                        sql0 += "or dept_id='" + person.getDeptId() + "'";
                        System.out.println(sql);
                    }
                    if (person.getSalary() != 0) {
                        sql0 += "or salary='" + person.getSalary() + "'";
                    }
                    if (person.getSalary2() != 0) {
                        sql0 += "or salary='" + person.getSalary2() + "'";
                    }
                    if (person.getSalary3() != 0) {
                        sql0 += "or salary='" + person.getSalary3() + "'";
                    }
                    ResultSet rs2 = stat.executeQuery(sql0 + "order by salary asc");
                    List<Person> list2 = new ArrayList<Person>();
                    while (rs2.next()) {
                        person = new Person(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                        list.add(person);
                    }
                    System.out.println("这是升序");
                    for (Person person1 : list) {
                        System.out.println(person1.getId() + "-->" + person1.getName() + "-->" + person1.getSex() + "-->" + person1.getDeptId() + "-->" + person1.getSalary());
                    }
                }
            }
            if (i2 == 2) {
                if (person.getId() != 0) {
                    sql0 += "or id = '" + person.getId() + "'";
                }
                if (person.getName() != null) {
                    sql0 += "or name like '%" + person.getName() + "%'";
                    System.out.println(sql0);
                }
                if (person.getSex() != 0) {
                    sql0 += "or sex='" + person.getSex() + "'";
                }
                if (person.getDeptId() != 0) {
                    sql0 += "or dept_id='" + person.getDeptId() + "'";
                }
                if (person.getSalary() != 0) {
                    sql0 += "or salary='" + person.getSalary() + "'";
                }
                if (person.getSalary2() != 0) {
                    sql0 += "or salary='" + person.getSalary2() + "'";
                }
                if (person.getSalary3() != 0) {
                    sql0 += "or salary='" + person.getSalary3() + "'";
                }
                ResultSet rs2 = stat.executeQuery(sql0);
                List<Person> list2 = new ArrayList<Person>();
                while (rs2.next()) {
                    person = new Person(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5));
                    list.add(person);
                }
                for (Person person1 : list) {
                    System.out.println(person1.getId() + "-->" + person1.getName() + "-->" + person1.getSex() + "-->" + person1.getDeptId() + "-->" + person1.getSalary());
                }
            }
        }
        return person;
    }
    public Person getPersonforId(int id) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from person where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        List<Person> list=new ArrayList<Person>();
        while (rs.next()) {
            person = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(person);
            list.add(person);
        }
        for (Person person1:list) {
            System.out.println(person1.getId()+"-->"+person1.getName()+"-->"+person1.getSex()+"-->"+person1.getDeptId()+"-->"+person1.getSalary());
        }
        return person;
    }
    public Person getPerson() throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from person";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        List<Person> list=new ArrayList<Person>();
        while (rs.next()) {
            person = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(person);
            list.add(person);
        }
        for (Person person1:list) {
            System.out.println(person1.getId()+"-->"+person1.getName()+"-->"+person1.getSex()+"-->"+person1.getDeptId()+"-->"+person1.getSalary());
        }
        return person;
    }
    public Person getPersonforName(String name) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from person where name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        List<Person> list=new ArrayList<Person>();
        while (rs.next()) {
            person = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(person);
            list.add(person);
        }
        for (Person person1:list) {
            System.out.println(person1.getId()+"-->"+person1.getName()+"-->"+person1.getSex()+"-->"+person1.getDeptId()+"-->"+person1.getSalary());
        }
        return person;
    }
    public Person getPersonforDeptId(int deptId) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from person where dept_id=?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, deptId);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        List<Person> list=new ArrayList<Person>();
        while (rs.next()) {
            person = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(person);
            list.add(person);
        }
        for (Person person1:list) {
            System.out.println(person1.getId()+"-->"+person1.getName()+"-->"+person1.getSex()+"-->"+person1.getDeptId()+"-->"+person1.getSalary());
        }
        return person;
    }
    public Person getPersonforSalary(String  salary) throws SQLException {
        Connection conn = null;
        conn = ConnectUtil.getCon();
        String sql = "select * from person where salary>?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,salary);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        List<Person> list=new ArrayList<Person>();
        while (rs.next()) {
            person = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(person);
            list.add(person);
        }
        for (Person person1:list) {
            System.out.println(person1.getId()+"-->"+person1.getName()+"-->"+person1.getSex()+"-->"+person1.getDeptId()+"-->"+person1.getSalary());
        }
        return person;
    }
    public int addperson(Person p) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="insert into person values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,p.getId());
        ps.setString(2,p.getName());
        ps.setInt(3,p.getSex());
        ps.setInt(4,p.getDeptId());
        ps.setInt(5,p.getSalary());
        int i=ps.executeUpdate();
        return i;
    }
    public  int updatePerson(Person person) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="update person set name=?,sex=?, dept_id=?,salary=? where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,person.getName());
        ps.setInt(2,person.getSex());
        ps.setInt(3,person.getDeptId());
        ps.setInt(4,person.getSalary());
        ps.setInt(5,person.getId());
        int i=ps.executeUpdate();
        return i;
    }
    public  int deletePerson(Person person) throws SQLException {
        Connection conn=null;
        conn= ConnectUtil.getCon();
        String sql="delete from person where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,person.getId());
        int i=ps.executeUpdate();
        return i;
    }
}
