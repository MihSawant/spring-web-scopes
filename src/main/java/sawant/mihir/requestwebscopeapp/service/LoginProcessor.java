package sawant.mihir.requestwebscopeapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String userName;
    private String password;

    public boolean login(){
        String userName = this.getUserName();
        String password = this.getPassword();

        if("Admin".equals(userName) && "test".equals(password)){
            return true;
        } else {
            return false;
        }
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
