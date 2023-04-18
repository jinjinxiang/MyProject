package Pro.pojo;

public class Tuser {
    private int id;
    private String account;
    private String password;
    private String username;
    private int roleId;
    private int aaaa;

    public Tuser() {
    }

    public Tuser(int id, String account, String password, String username, int roleId) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.username = username;
        this.roleId = roleId;
    }

    public Tuser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Tuser(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "tUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
