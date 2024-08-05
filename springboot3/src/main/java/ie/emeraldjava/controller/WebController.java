package ie.emeraldjava.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * https://www.geeksforgeeks.org/returning-an-html-page-from-a-restful-controller-in-spring-boot/
 * https://stackoverflow.com/questions/42393211/how-can-i-serve-static-html-from-spring-boot?rq=3
 */
@Slf4j
@Controller
public class WebController {

    @PostConstruct
    public void xx() {
        log.info("WebController");
    }

    /**
     * https://stackoverflow.com/questions/31876389/how-to-serve-static-html-content-page-in-spring-boot
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

//    @GetMapping("/")
//    public ModelAndView homePage() {
//        log.info("WebController - /");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
////        return new ClassPathResource("html/index.html");
//    }
}
