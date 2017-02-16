package test.entity;

public class User {

    private int id;
    private String full_name;
    private String email;
    private String stat;

    public User() {
    }

    public User(String full_name, String email, String stat) {
        this.full_name = full_name;
        this.email = email;
        this.stat = stat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
