package challenge_meli.magneto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsPageController {


    @GetMapping("/view-stats")
    public String statsPage() {
        return "stats";
    }

}
