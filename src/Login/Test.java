package Login;

public class Test {
    public static void main(String[] args) {
        Register user = new Register();
        user.setId("lihuaa");
        user.setPassword("1133");
        user.setBirth("1989-11-12");
        HandelInsertData handelInsertData = new HandelInsertData();
        handelInsertData.writeRegisterModel(user);

        Login loginer = new Login();
        loginer.setId("lihuaa");
        loginer.setPassword("1133");
        HandelLogin handelLogin = new HandelLogin();
        handelLogin.queryVerify(loginer);
        if (loginer.isLoginSuccess()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}
