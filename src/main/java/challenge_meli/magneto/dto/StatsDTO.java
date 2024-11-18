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

    public long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public long getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
