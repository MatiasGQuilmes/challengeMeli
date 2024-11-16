package challenge_meli.magneto.service.mapper;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IDnaMapper {

    IDnaMapper INSTANCE = Mappers.getMapper(IDnaMapper.class);

    @Mapping(target = "id", ignore = true) // Ignorar el ID ya que será generado automáticamente
    Dna dnaDTOtoEntity(DnaDTO dnaSequenceDTO);

    DnaDTO entityToDNADTO(Dna dnaSequence);
}
