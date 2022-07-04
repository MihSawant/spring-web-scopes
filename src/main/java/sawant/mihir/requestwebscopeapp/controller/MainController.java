package sawant.mihir.requestwebscopeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sawant.mihir.requestwebscopeapp.LoginProcessor;
import sawant.mihir.requestwebscopeapp.service.LoginCountService;
import sawant.mihir.requestwebscopeapp.service.LoginSessionManagement;

@Controller
public record MainController(LoginProcessor processor,
                             LoginSessionManagement loginSessionManagement,
                             LoginCountService loginCountService) {

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
            return "redirect:/main";
        } else{
            page.addAttribute("message", "Login Failed");
        }
        return "login-page";
    }

    @GetMapping("/main")
    public String homePage(@RequestParam(required = false) String logOut, Model page){

        if(logOut != null){
            loginSessionManagement.setUserName(null);
        }

        String userName = loginSessionManagement.getUserName();

        if(userName == null){
            return "redirect:/";
        }

        page.addAttribute("userName", userName);
        page.addAttribute("count", loginCountService.getCount());
        return "main";
    }
}
