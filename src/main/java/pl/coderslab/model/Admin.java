package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class Admin {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private int superAdmin;
    private boolean enable;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", superAdmin=" + superAdmin +
                ", enable=" + enable +
                '}';
    }

    public Admin(){
    }

    public Admin(String first_name, String last_name, String email, String password, int superAdmin, boolean enable){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        hashPassword(password);
        this.superAdmin = superAdmin;
        this.enable = enable;
    }

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(int superAdmin) {
        this.superAdmin = superAdmin;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }


}
