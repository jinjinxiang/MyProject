package Pro.pojo;

public class Dept {
    private  int id;
    private  String dname;

    public Dept() {
    }

    public Dept(int id, String dname) {
        this.id = id;
        this.dname = dname;
    }

    public Dept(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                '}';
    }
}
