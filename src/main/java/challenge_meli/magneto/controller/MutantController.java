package challenge_meli.magneto.controller;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.service.IMutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @Autowired
    IMutantService mutantService;

    @PostMapping("/mutant")
    public ResponseEntity<Void> isMutant(@RequestBody DnaDTO dnaDTO) {
        boolean isMutant = mutantService.isMutant(dnaDTO.getDna());

        if (isMutant) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

}
