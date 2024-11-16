package challenge_meli.magneto.dto;

import lombok.Data;

@Data
public class StatsDTO {


    private long countMutantDNA;
    private long countHumanDNA;
    private double ratio;

    public StatsDTO() {
    }

    public StatsDTO(long countMutantDNA, long countHumanDNA, double ratio) {
        this.countMutantDNA = countMutantDNA;
        this.countHumanDNA = countHumanDNA;
        this.ratio = ratio;
    }

}
