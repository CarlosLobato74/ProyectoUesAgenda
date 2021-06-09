
package datos;

public class Login {
    static int userId;
    private String user;
    private String  password;
    
    private String firstN;
    private String lastN;
    private String phone;
    private String address;

    public Login() {
    }

    public Login(int userId) {
        this.userId = userId;
    }
    
    public Login(int userId, String user, String password) {
        this.userId = userId;
        this.user = user;
        this.password = password;
    }

    public Login(int userId, String user, String password, String firstN, String lastN, String phone, String address) {
        this.userId = userId;
        this.user = user;
        this.password = password;
        this.firstN = firstN;
        this.lastN = lastN;
        this.phone = phone;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstN() {
        return firstN;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }

   
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Login{" + "userId=" + userId + ", user=" + user + ", password=" + password + ", firstN=" + firstN + ", LastN=" + lastN + ", phone=" + phone + ", address=" + address + '}';
    }
    
    
    
    
   
}
