package houseway.houseway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String login() {
        return "views/admin/login";
    }

    @GetMapping("/index")
    public String index() {
        return "views/admin/index";
    }


    @GetMapping("/product")
    public String product() {
        return "views/admin/product";
    }


    @GetMapping("/member")
    public String member() {
        return "views/admin/member";
    }

}
