package challenge_meli.magneto.service.mapper;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T20:58:04-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class IDnaMapperImpl implements IDnaMapper {

    @Override
    public Dna dnaDTOtoEntity(DnaDTO dnaSequenceDTO) {
        if ( dnaSequenceDTO == null ) {
            return null;
        }

        Dna dna1 = new Dna();

        String[] dna = dnaSequenceDTO.getDna();
        if ( dna != null ) {
            dna1.setDna( Arrays.copyOf( dna, dna.length ) );
        }
        dna1.setMutant( dnaSequenceDTO.isMutant() );

        return dna1;
    }

    @Override
    public DnaDTO entityToDNADTO(Dna dnaSequence) {
        if ( dnaSequence == null ) {
            return null;
        }

        DnaDTO dnaDTO = new DnaDTO();

        String[] dna = dnaSequence.getDna();
        if ( dna != null ) {
            dnaDTO.setDna( Arrays.copyOf( dna, dna.length ) );
        }
        dnaDTO.setMutant( dnaSequence.isMutant() );

        return dnaDTO;
    }
}
