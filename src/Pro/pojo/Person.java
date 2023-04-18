package Pro.pojo;

public class Person {
    private int id;
    private String name;
    private int sex;
    private int deptId;
    private int salary;
    private int salary2;
    private int salary3;
    private String con;

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public Person() {
    }

    public Person(int id, String name, int sex, int deptId, int salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.deptId = deptId;
        this.salary = salary;
    }

    public Person( String name, int sex, int deptId, int salary,int id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.deptId = deptId;
        this.salary = salary;
    }
    public Person(int id) {
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary2() {
        return salary2;
    }

    public void setSalary2(int salary2) {
        this.salary2 = salary2;
    }

    public int getSalary3() {
        return salary3;
    }

    public void setSalary3(int salary3) {
        this.salary3 = salary3;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", deptId=" + deptId +
                ", salary=" + salary +
                '}';
    }
}
