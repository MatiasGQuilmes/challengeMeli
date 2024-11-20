package challenge_meli.magneto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class StatsPageController {


    @GetMapping("/view-stats")
    public String statsPage() {
        return "stats";
    }

}
