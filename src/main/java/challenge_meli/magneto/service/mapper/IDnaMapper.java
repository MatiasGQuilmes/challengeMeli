package challenge_meli.magneto.service.mapper;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IDnaMapper {

    Dna dnaDTOtoEntity(DnaDTO dnaSequenceDTO);

    DnaDTO entityToDNADTO(Dna dnaSequence);
}
