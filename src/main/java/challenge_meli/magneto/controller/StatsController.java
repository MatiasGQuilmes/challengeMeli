package challenge_meli.magneto.controller;

import challenge_meli.magneto.dto.StatsDTO;
import challenge_meli.magneto.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatsController {

    @Autowired
    private IStatsService statsService;

    @GetMapping("/stats")
    public StatsDTO getStats() {
        return statsService.getStats();
    }
}