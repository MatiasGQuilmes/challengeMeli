package challenge_meli.magneto.serviceTest;

import challenge_meli.magneto.constant.AppConstants;
import challenge_meli.magneto.exception.InvalidDnaException;
import challenge_meli.magneto.exception.DatabaseException;
import challenge_meli.magneto.model.Dna;
import challenge_meli.magneto.repository.IDnaRepository;
import challenge_meli.magneto.service.implement.MutantServiceImpl;
import challenge_meli.magneto.service.mapper.IDnaMapper;
import challenge_meli.magneto.dto.DnaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MutantServiceTest {

    @InjectMocks
    private MutantServiceImpl mutantService;

    @Mock
    private IDnaRepository dnaRepository;

    @Mock
    private IDnaMapper dnaMapper;

    private DnaDTO dnaDTO;
    private Dna dnaEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dnaDTO = new DnaDTO();
        dnaDTO.setDna(new String[] {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        dnaDTO.setMutant(true);

        dnaEntity = new Dna(dnaDTO.getDna(),dnaDTO.isMutant());
    }

    @Test
    void testIsMutant_True() {
        when(dnaMapper.dnaDTOtoEntity(any(DnaDTO.class))).thenReturn(dnaEntity);
        when(dnaRepository.save(any(Dna.class))).thenReturn(dnaEntity);

        boolean result = mutantService.isMutant(new String[] {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        assertTrue(result);
        verify(dnaRepository, times(1)).save(any(Dna.class));
    }

    @Test
    void testIsMutant_False() {
        when(dnaMapper.dnaDTOtoEntity(any(DnaDTO.class))).thenReturn(dnaEntity);
        when(dnaRepository.save(any(Dna.class))).thenReturn(dnaEntity);

        boolean result = mutantService.isMutant(new String[] {"ATGC", "CAGT", "TCTA", "AGCG"});

        assertFalse(result);
        verify(dnaRepository, times(1)).save(any(Dna.class));
    }

    @Test
    void testIsMutant_InvalidDna() {
        assertThrows(InvalidDnaException.class, () -> mutantService.isMutant(null));
        assertThrows(InvalidDnaException.class, () -> mutantService.isMutant(new String[] {}));
    }


    @Test
    void testIsMutant_DatabaseException() {
        when(dnaMapper.dnaDTOtoEntity(any(DnaDTO.class))).thenReturn(dnaEntity);
        when(dnaRepository.save(any(Dna.class))).thenThrow(new RuntimeException("Simulated database error"));

        DatabaseException exception = assertThrows(DatabaseException.class, () -> {
            mutantService.isMutant(new String[] {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        });

        assertEquals(AppConstants.ERROR_DATABASE_SAVE, exception.getMessage());
        assertThrows(DatabaseException.class, () -> mutantService.isMutant(new String[] {"ATGC", "CAGT", "TTAT", "AGCG"}));
    }
}
