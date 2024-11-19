package challenge_meli.magneto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dna {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String[] dna;

    private boolean isMutant;


    public Dna() {}

    public Dna(String[] dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
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
