package challenge_meli.magneto.repository;

import challenge_meli.magneto.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDnaRepository extends JpaRepository<Dna, Long> {

    int countByIsMutant(boolean isMutant);

    @Query("SELECT SUM(CASE WHEN a.isMutant = true THEN 1 ELSE 0 END), SUM(CASE WHEN a.isMutant = false THEN 1 ELSE 0 END) FROM Dna a")
    Object[] countDnaStatistics();

}
