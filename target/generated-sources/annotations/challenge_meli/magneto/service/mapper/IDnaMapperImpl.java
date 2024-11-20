package challenge_meli.magneto.service.mapper;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T13:14:54-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class IDnaMapperImpl implements IDnaMapper {

    @Override
    public Dna dnaDTOtoEntity(DnaDTO dnaSequenceDTO) {
        if ( dnaSequenceDTO == null ) {
            return null;
        }

        Dna dna = new Dna();

        return dna;
    }

    @Override
    public DnaDTO entityToDNADTO(Dna dnaSequence) {
        if ( dnaSequence == null ) {
            return null;
        }

        DnaDTO dnaDTO = new DnaDTO();

        return dnaDTO;
    }
}
