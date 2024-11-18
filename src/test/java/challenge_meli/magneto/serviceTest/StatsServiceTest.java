package challenge_meli.magneto.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import challenge_meli.magneto.dto.StatsDTO;
import challenge_meli.magneto.repository.IDnaRepository;
import challenge_meli.magneto.service.implement.StatsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


public class StatsServiceTest {

    @Mock
    private IDnaRepository dnaRepository;
    @InjectMocks
    private StatsServiceImpl statsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStats() {
        when(dnaRepository.countByIsMutant(true)).thenReturn(40);
        when(dnaRepository.countByIsMutant(false)).thenReturn(60);

        StatsDTO statsDTO = statsService.getStats();

        assertEquals(40, statsDTO.getCount_mutant_dna());
        assertEquals(60, statsDTO.getCount_human_dna());
        assertEquals(0.6667, statsDTO.getRatio(), 0.0001);
    }
}
