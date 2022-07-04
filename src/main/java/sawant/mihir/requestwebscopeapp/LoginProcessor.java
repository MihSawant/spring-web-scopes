package sawant.mihir.requestwebscopeapp;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import sawant.mihir.requestwebscopeapp.service.LoginCountService;
import sawant.mihir.requestwebscopeapp.service.LoginSessionManagement;

@Component
@RequestScope
public class LoginProcessor {
    private String userName;
    private String password;

    private LoginSessionManagement loginSessionManagement;

    private LoginCountService loginCountService;

    public LoginProcessor(LoginSessionManagement loginSessionManagement,
                          LoginCountService loginCountService){
        this.loginSessionManagement = loginSessionManagement;
        this.loginCountService = loginCountService;
    }

    public boolean login(){
        loginCountService.addCount();
        String userName = this.getUserName();
        String password = this.getPassword();

        boolean login = false;

        if("Admin".equals(userName) && "test".equals(password)){
            login = true;
            loginSessionManagement.setUserName(userName);
        }
        return login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
