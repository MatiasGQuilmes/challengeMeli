package challenge_meli.magneto.dto;

import lombok.Data;

@Data
public class StatsDTO {


    private long count_mutant_dna;
    private long count_human_dna;
    private double ratio;

    public StatsDTO() {
    }

    public StatsDTO(long countMutantDNA, long countHumanDNA, double ratio) {
        this.count_mutant_dna = countMutantDNA;
        this.count_human_dna = countHumanDNA;
        this.ratio = ratio;
    }


}
