package sawant.mihir.requestwebscopeapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void addCount(){
        this.count++;
    }

    public int getCount(){
        return this.count;
    }
}
