package Pro.pojo;

public class Trole {
    private int id;
    private String role;

    public Trole() {
    }

    public Trole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public Trole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "tRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
