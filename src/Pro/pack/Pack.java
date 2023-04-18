package Pro.pack;

import Pro.dao.Deptdao;
import Pro.dao.Persondao;
import Pro.dao.TroleDao;
import Pro.dao.TuserDao;
import Pro.pojo.Dept;
import Pro.pojo.Person;
import Pro.pojo.Trole;
import Pro.pojo.Tuser;
import Pro.test.ConTest;

import java.sql.SQLException;
import java.util.Scanner;

public class Pack {
    public int save() throws SQLException {
        System.out.println("请输入您的Id");
        Scanner s1=new Scanner(System.in);
        int id=s1.nextInt();
        System.out.println("请输入您要注册的账号");
        Scanner s2=new Scanner(System.in);
        String account=s2.next();
        System.out.println("请输入您要注册的密码");
        Scanner s3=new Scanner(System.in);
        String password=s3.next();
        System.out.println("请输入您的名字");
        Scanner s4=new Scanner(System.in);
        String username=s4.next();
        System.out.println("请输入您的管理员id");
        Scanner s5=new Scanner(System.in);
        int roleID=s5.nextInt();
        Tuser t=new Tuser(id,account,password,username,roleID);
        TuserDao td=new TuserDao();
        int i= td.addAccount(t);
        System.out.println("注册成功");
        return login();
    }
    public int save2() throws SQLException {
        System.out.println("请输入新增的Id");
        Scanner s1=new Scanner(System.in);
        int id=s1.nextInt();
        System.out.println("请输入您要新增的账号");
        Scanner s2=new Scanner(System.in);
        String account=s2.next();
        System.out.println("请输入您要新增的密码");
        Scanner s3=new Scanner(System.in);
        String password=s3.next();
        System.out.println("请输入您新增的名字");
        Scanner s4=new Scanner(System.in);
        String username=s4.next();
        System.out.println("请输入您新增的管理员id");
        Scanner s5=new Scanner(System.in);
        int roleID=s5.nextInt();
        Tuser t=new Tuser(id,account,password,username,roleID);
        TuserDao td=new TuserDao();
        int i= td.addAccount(t);
        System.out.println("新增成功");
        return oper2();
    }
    public int login() throws SQLException {
        System.out.println("请输入您的账号");
        Scanner s1=new Scanner(System.in);
        String account=s1.next();
        System.out.println("请输入您的密码");
        Scanner s2=new Scanner(System.in);
        String password=s2.next();
        Tuser tuser=new Tuser(account,password);
        TuserDao tuser2= new TuserDao();
        Tuser tuser3=tuser2.getAccount(account,password);
        if (tuser3!=null){
            if(tuser3.getRoleId()==1){
                System.out.println("登录成功,您是管理员");
                control();
            }else if (tuser3.getRoleId()==2){
                System.out.println("登录成功,您是普通用户");
                control2();
            }else if(tuser3.getRoleId()==3){
                System.out.println("登录成功,您暂时没有权限");
                System.exit(0);
            }
        }else {
            System.out.println("账号或者密码错误");
            return login();
        }
        ConTest ct=new ConTest();
        return ct.test();
    }
    public int control() throws SQLException {
        System.out.println("请选择您要进行的操作:1.员工管理 2.用户管理 3.角色管理 4.部门管理 5.退出账号");
        Scanner s2=new Scanner(System.in);
        int i2=s2.nextInt();
        try{
            if(i2==1) {
            oper();
            }
            if(i2==2){
            oper2();
            }
            if(i2==3){
            oper3();
            }
            if(i2==4){
            oper4();
            }
            if(i2==5){
                ConTest ct=new ConTest();
                return ct.test();
            }
        } catch (SQLException throwables) {
            System.out.println("请输入正确的操作");;
        }
        return oper();
    }
    public int control2() throws SQLException {
        System.out.println("请选择您要进行的操作:1.查询 2.退出");
        while (true) {
            Scanner s1 = new Scanner(System.in);
            int i = s1.nextInt();
            try {
                if (i == 1) {
                    System.out.println("1.按条件查询 2.全部查询");
                    Scanner s3 = new Scanner(System.in);
                    int i3 = s3.nextInt();
                    if (i3 == 1) {
                        Person p = new Person();
                        Persondao pd = new Persondao();
                        Person i4 = pd.getPersonfor(p);
                        if (i4 == null) {
                            System.out.println("输入的条件查询不到结果");
                        }
                        return control2();
                    }
                    if (i3==2){
                        Person p = new Person();
                        Persondao pd = new Persondao();
                        Person i4 = pd.getPerson();
                        return control2();
                    }
                }
                if(i==2){
                    ConTest ct=new ConTest();
                    ct.test();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("请输入正确的操作");
            }
        }
    }
    public  int  oper() throws SQLException {
        System.out.println("请输入您要进行的操作:1.查询 2.新建 3.修改 4.删除 5.返回");
        while (true) {
            Scanner s1 = new Scanner(System.in);
            int i = s1.nextInt();
            try {
                if (i == 1) {
                    System.out.println("1.按条件查询 2.全部查询");
                    Scanner s2=new Scanner(System.in);
                    int i2=s2.nextInt();
                    if(i2==1){
                        Person p=new Person();
                        Persondao pd=new Persondao();
                        Person i3=pd.getPersonfor(p);
                        if(i3==null){
                            System.out.println("输入的条件查询不到结果");
                            return oper();
                        }
                        return oper();
                    }
                    if(i2==2){
                        Person person1 = new Person();
                        Persondao p1 = new Persondao();
                        Person person2 = p1.getPerson();
                        return oper();
                        }
                    }
//                    System.out.println("请输入您要查询的条件:1.编号 2.名字 3.部门 4.工资范围 ");
//                    Scanner s2 = new Scanner(System.in);
//                    int i2 = s2.nextInt();
//                    if (i2 == 1) {
//                        System.out.println("请输入您要查询的编号");
//                        Scanner s3 = new Scanner(System.in);
//                        int id = s3.nextInt();
//                        Person person1 = new Person(id);
//                        Persondao p1 = new Persondao();
//                        Person person2 = p1.getPersonforId(id);
//                        System.out.println(person2);
//                    } else if (i2 == 2) {
//                        System.out.println("请输入您要查询的名字");
//                        Scanner s4 = new Scanner(System.in);
//                        String name = s4.next();
//                        Person person1 = new Person(name);
//                        Persondao p1 = new Persondao();
//                        Person person2 = p1.getPersonforName(name);
//                        System.out.println(person2);
//                    } else if (i2 == 3) {
//                        System.out.println("请输入您要查询的部门编号");
//                        Scanner s4 = new Scanner(System.in);
//                        int deptId = s4.nextInt();
//                        Person person1 = new Person(deptId);
//                        Persondao p1 = new Persondao();
//                        Person person2 = p1.getPersonforDeptId(deptId);
//                        System.out.println(person2);
//                    } else if (i2 == 4) {
//                        System.out.println("请输入您要查询工资范围");
//                        Scanner s4 = new Scanner(System.in);
//                        String salary = s4.next();
//                        Person person1 = new Person(salary);
//                        Persondao p1 = new Persondao();
//                        Person person2 = p1.getPersonforSalary(salary);
//                        System.out.println(person2);
//                    }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请输入正确的操作");
            }
            try {
                if (i == 2) {
                    System.out.println("请输入要新增的Id");
                    Scanner s = new Scanner(System.in);
                    int id = s1.nextInt();
                    System.out.println("请输入您要新增的姓名");
                    Scanner s2 = new Scanner(System.in);
                    String name = s2.next();
                    System.out.println("请输入他/她的性别,用0/1代替");
                    Scanner s3 = new Scanner(System.in);
                    int sex = s3.nextInt();
                    System.out.println("请输入他/她的部门编号");
                    Scanner s4 = new Scanner(System.in);
                    int deptId = s4.nextInt();
                    System.out.println("请输入他/她的工资");
                    Scanner s5 = new Scanner(System.in);
                    int salary = s5.nextInt();
                    Person p1 = new Person(id, name, sex, deptId, salary);
                    Persondao pd = new Persondao();
                    int i2 = pd.addperson(p1);
                    System.out.println("新增成功");
                    return oper();
                }
            } catch (SQLException throwables) {
                System.out.println("请输入正确的操作");
            }
            try {
                if (i == 3) {
                    System.out.println("请输入要修改的编号");
                    Scanner s = new Scanner(System.in);
                    int id = s1.nextInt();
                    System.out.println("请输入您要改成什么名字");
                    Scanner s2 = new Scanner(System.in);
                    String name = s2.next();
                    System.out.println("请输入您要改成什么性别");
                    Scanner s3 = new Scanner(System.in);
                    int sex = s3.nextInt();
                    System.out.println("请输入您要改成什么部门");
                    Scanner s4 = new Scanner(System.in);
                    int deptId = s4.nextInt();
                    System.out.println("请输入您要改成多少工资");
                    Scanner s5 = new Scanner(System.in);
                    int salary = s5.nextInt();
                    Person p1 = new Person(name, sex, deptId, salary,id);
                    Persondao pd = new Persondao();
                    int i2 = pd.updatePerson(p1);
                    System.out.println("修改成功");
                    return oper();
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("请输入正确的操作");
            }
            try {
                if (i == 4) {
                    System.out.println("请输入要删除的编号");
                    Scanner s = new Scanner(System.in);
                    int id = s1.nextInt();
                    Person p1 = new Person(id);
                    Persondao pd = new Persondao();
                    int i2 = pd.deletePerson(p1);
                    System.out.println("删除成功");
                    return oper();
                }
            } catch (SQLException throwables) {
                System.out.println("请输入正确的操作");
            }
            if (i == 5) {
                return control();
            }
        }
    }
    public int oper2(){
        System.out.println("请输入您要进行的操作:1.查询 2.新建 3.修改 4.删除 5.返回");
        while (true){
            Scanner s1=new Scanner(System.in);
            int i1=s1.nextInt();
            try{
                if(i1==1){
                    System.out.println("1.按条件查询 2.全部查询");
                    Scanner s2=new Scanner(System.in);
                    int i2=s2.nextInt();
                    if(i2==1){
                        Tuser t=new Tuser();
                        TuserDao td=new TuserDao();
                        Tuser i3=td.getTuser(t);
                        System.out.println(i3);
                        if(i3==null){
                            System.out.println("输入的条件查询不到结果");
                            return oper2();
                        }
                        return oper2();
                    }
                    if(i2==2){
                        Tuser tuser = new Tuser();
                        TuserDao td = new TuserDao();
                        Tuser tuser2 = td.getTuserfor();
                        return oper2();
                    }
                }
            if(i1==2){
                    save2();
                    return oper2();
                }
                if(i1==3) {
                    System.out.println("请输入要修改的编号");
                    Scanner s = new Scanner(System.in);
                    int id = s1.nextInt();
                    System.out.println("请输入修改的账号");
                    Scanner s2 = new Scanner(System.in);
                    String account = s2.next();
                    System.out.println("请输入修改的密码");
                    Scanner s3 = new Scanner(System.in);
                    String password = s3.next();
                    System.out.println("请输入修改的名字");
                    Scanner s4 = new Scanner(System.in);
                    String username = s4.next();
                    System.out.println("请输入修改的管理员id");
                    Scanner s5 = new Scanner(System.in);
                    int roleId = s5.nextInt();
                    Tuser t1 = new Tuser(id, account, password, username, roleId);
                    TuserDao td = new TuserDao();
                    int i2 = td.updateTuser(t1);
                    System.out.println("修改成功");
                    return oper2();
                }
                if (i1 == 4) {
                    System.out.println("请输入要删除的编号");
                    Scanner s = new Scanner(System.in);
                    int id = s1.nextInt();
                    Tuser t1 = new Tuser(id);
                    TuserDao td = new TuserDao();
                    int i2 = td.deleteTuserdao(t1);
                    System.out.println("删除成功");
                    return oper2();
                }
                if (i1 == 5) {
                    return control();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public int oper3(){
        System.out.println("请输入您要进行的操作:1.查询 2.新建 3.修改 4.删除 5.返回");
        while (true){
            Scanner s1=new Scanner(System.in);
            int i1=s1.nextInt();
            try{
                if(i1==1) {
                    System.out.println("1.按条件查询 2.全部查询");
                    Scanner s2 = new Scanner(System.in);
                    int i2 = s2.nextInt();
                    if (i2 == 1) {
                        Trole t= new Trole();
                        TroleDao td = new TroleDao();
                        Trole i3 = td.getTrole(t);
                        System.out.println(i3);
                        if (i3 == null) {
                            System.out.println("输入的条件查询不到结果");
                            return oper3();
                        }
                        return oper3();
                    }
                    if (i2 == 2) {
                        Trole trole = new Trole();
                        TroleDao td = new TroleDao();
                        Trole i3 = td.getTrolefor();
                        return oper3();
                    }
                }
                if(i1==2){
                    System.out.println("请输入您要新增的管理员id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    System.out.println("请输入您管理员id的权限");
                    Scanner s5=new Scanner(System.in);
                    String role=s5.next();
                    Trole t=new Trole(id,role);
                    TroleDao td=new TroleDao();
                    int i= td.addAccount(t);
                    System.out.println("新增成功");
                    return oper3();
                }
                if(i1==3){
                    System.out.println("请输入您要修改的管理员id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    System.out.println("请输入您修改的管理员id的权限");
                    Scanner s5=new Scanner(System.in);
                    String role=s5.next();
                    Trole t=new Trole(id,role);
                    TroleDao td=new TroleDao();
                    int i= td.updateTrole(t);
                    System.out.println("修改成功");
                    return oper3();
                }
                if(i1==4){
                    System.out.println("请输入您要删除的管理员id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    Trole t=new Trole(id);
                    TroleDao td=new TroleDao();
                    int i= td.deleteTrole(t);
                    System.out.println("删除成功");
                    return oper3();
                }
                if (i1 == 5) {
                    return control();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请输入正确的操作");;
            }
        }
    }
    public int oper4(){
        System.out.println("请输入您要进行的操作:1.查询 2.新建 3.修改 4.删除 5.返回");
        while (true){
            Scanner s1= new Scanner(System.in);
            int i1=s1.nextInt();
            try {
                if(i1==1){
                        System.out.println("1.按条件查询 2.全部查询");
                        Scanner s2=new Scanner(System.in);
                        int i2=s2.nextInt();
                        if(i2==1){
                            Dept d=new Dept();
                            Deptdao td=new Deptdao();
                            Dept i3=td.getDept(d);
                            if(i3==null){
                                System.out.println("查询不到结果");
                            }
                            return oper4();
                        }
                        if(i2==2){
                            Dept dept = new Dept();
                            Deptdao dd = new Deptdao();
                            Dept dept1 = dd.getDeptfor();
                            return oper4();
                        }
                }
                if(i1==2){
                    System.out.println("请输入您要新增的部门id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    System.out.println("请输入您新增部门的名称");
                    Scanner s5=new Scanner(System.in);
                    String dname=s5.next();
                    Dept d =new Dept(id,dname);
                    Deptdao td=new Deptdao();
                    int i= td.addDept(d);
                    System.out.println("新增成功");
                    return oper4();
                }
                if(i1==3){
                    System.out.println("请输入您要修改的部门id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    System.out.println("请输入您修改后部门的名称");
                    Scanner s5=new Scanner(System.in);
                    String dname=s5.next();
                    Dept d =new Dept(id,dname);
                    Deptdao td=new Deptdao();
                    int i= td.updateDept(d);
                    System.out.println("修改成功");
                    oper4();
                }
                if (i1==4){
                    System.out.println("请输入您要删除的部门id");
                    Scanner s4=new Scanner(System.in);
                    int id=s4.nextInt();
                    Dept d =new Dept(id);
                    Deptdao td=new Deptdao();
                    int i= td.deleteDept(d);
                    System.out.println("删除成功");
                    return oper4();
                }
                if (i1==5){
                    return control();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
