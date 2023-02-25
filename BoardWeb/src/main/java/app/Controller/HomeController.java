package app.Controller;

import app.model.SaramDAO;
import app.model.SaramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class HomeController {
//    @Autowired
//    SaramDTO saramDTO;
//    @Autowired
//    SaramDAO saramDAO;
//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
//        logger.info("HomeController 환영 메세지 {}.", locale);
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//        String formattedDate = dateFormat.format(date);
//        model.addAttribute("serverTime", formattedDate );
//
//        System.out.println("--- 빈 사용 하기 ---");
//
//        saramDAO.selectAll();

        return "index";
    }

}