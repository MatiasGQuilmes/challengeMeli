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

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
