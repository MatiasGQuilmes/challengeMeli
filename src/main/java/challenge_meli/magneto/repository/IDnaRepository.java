package challenge_meli.magneto.repository;

import challenge_meli.magneto.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDnaRepository extends JpaRepository<Dna, Long> {

    int countByIsMutant(boolean isMutant);


    @Query("SELECT COUNT(a) FROM Adn a WHERE a.isMutant = true")
    long countMutantDna();

    @Query("SELECT COUNT(a) FROM Adn a WHERE a.isMutant = false")
    long countHumanDna();
}
