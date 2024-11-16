package challenge_meli.magneto.mapperTest;

import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import challenge_meli.magneto.service.mapper.IDnaMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDnaMapperTest {

    private final IDnaMapper mapper = IDnaMapper.INSTANCE;

    @Test
    void shouldMapDnaDTOToDnaEntity() {
        // Crear un DnaDTO de prueba
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(new String[]{"ATGC", "CAGT", "TTAT", "AGGG"});

        // Realizar el mapeo
        Dna dnaEntity = mapper.dnaDTOtoEntity(dnaDTO);

        // Verificar que el mapeo es correcto
        assertNotNull(dnaEntity);
        assertArrayEquals(dnaDTO.getDna(), dnaEntity.getDna()); // Verifica que el contenido del DNA es el mismo
    }

    @Test
    void shouldMapDnaEntityToDnaDTO() {
        // Crear una entidad Dna de prueba
        Dna dnaEntity = new Dna();
        dnaEntity.setDna(new String[]{"ATGC", "CAGT", "TTAT", "AGGG"});

        // Realizar el mapeo
        DnaDTO dnaDTO = mapper.entityToDNADTO(dnaEntity);

        // Verificar que el mapeo es correcto
        assertNotNull(dnaDTO);
        assertArrayEquals(dnaEntity.getDna(), dnaDTO.getDna()); // Verifica que el contenido del DNA es el mismo
    }
}
