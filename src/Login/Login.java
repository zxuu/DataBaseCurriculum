package Login;

public class Login {
    boolean loginSuccess;
    String id;
    String password;

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginSuccess(boolean loginSuccess) {

        this.loginSuccess = loginSuccess;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
