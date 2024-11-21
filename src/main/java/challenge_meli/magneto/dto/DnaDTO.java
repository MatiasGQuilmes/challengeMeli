package challenge_meli.magneto.dto;

import challenge_meli.magneto.model.Dna;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DnaDTO {

    private String[] dna;

    private boolean isMutant;

    public DnaDTO() {}

    public DnaDTO(Dna dna) {
        this.dna = dna.getDna();
        this.isMutant = dna.isMutant();
    }

}
