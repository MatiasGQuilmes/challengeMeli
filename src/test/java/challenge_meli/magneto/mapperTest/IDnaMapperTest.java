package challenge_meli.magneto.mapperTest;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import challenge_meli.magneto.service.mapper.IDnaMapper;
import challenge_meli.magneto.service.mapper.IDnaMapperImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

public class IDnaMapperTest {

    @InjectMocks
    IDnaMapper mapper = new IDnaMapperImpl();

    @Test
    void shouldMapDnaDTOToDnaEntity() {
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(new String[]{"ATGC", "CAGT", "TTAT", "AGGG"});

        Dna dnaEntity = mapper.dnaDTOtoEntity(dnaDTO);

        assertNotNull(dnaEntity);
        assertArrayEquals(dnaDTO.getDna(), dnaEntity.getDna());
    }

    @Test
    void shouldMapDnaEntityToDnaDTO() {
        Dna dnaEntity = new Dna();
        dnaEntity.setDna(new String[]{"ATGC", "CAGT", "TTAT", "AGGG"});

        DnaDTO dnaDTO = mapper.entityToDNADTO(dnaEntity);

        assertNotNull(dnaDTO);
        assertArrayEquals(dnaEntity.getDna(), dnaDTO.getDna()); // Verifica que el contenido del DNA es el mismo
    }
}
