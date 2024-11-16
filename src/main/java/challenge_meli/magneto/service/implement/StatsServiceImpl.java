package challenge_meli.magneto.service.implement;

import challenge_meli.magneto.dto.StatsDTO;
import challenge_meli.magneto.repository.IDnaRepository;
import challenge_meli.magneto.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements IStatsService {

    @Autowired
    private IDnaRepository dnaRepository;
    @Override
    public StatsDTO getStats() {
        long countMutantDNA = dnaRepository.countByIsMutant(true);
        long countHumanDNA = dnaRepository.countByIsMutant(false);

        double ratio = countHumanDNA > 0 ? (double) countMutantDNA / countHumanDNA : 0;

        return new StatsDTO(countMutantDNA, countHumanDNA, ratio);
    }

}
