package sawant.mihir.requestwebscopeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sawant.mihir.requestwebscopeapp.service.LoginProcessor;

@Controller
public record MainController(LoginProcessor processor) {

    @GetMapping("/")
    public String getLogin(){
        return "login-page";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String userName,
                            @RequestParam String password,
                            Model page){

        processor.setUserName(userName);
        processor.setPassword(password);

        boolean loggedIn = processor().login();

        if(loggedIn){
            page.addAttribute("message", "You are successfully Logged In");
        } else{
            page.addAttribute("message", "Login Failed");
        }
        return "login-page";
    }
}
