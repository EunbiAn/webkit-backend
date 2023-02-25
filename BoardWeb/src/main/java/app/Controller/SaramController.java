package app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller 빈으로 등록됨!
@Controller
@RequestMapping("/saram")
public class SaramController {
    @GetMapping("/list")
    public String saram(){
        System.out.println("SaramController의 Saram 메소드 호출");
        return "saram/list";    // WEB-INF/views/saram/list.jsp
    }
    @GetMapping("/input")
    public String input(){
        System.out.println("SaramController의 input 메소드 호출");
        return "saram/input";    // WEB-INF/views/saram/input.jsp
    }
}
