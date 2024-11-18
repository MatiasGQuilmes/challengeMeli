package challenge_meli.magneto.controllerTest;

import challenge_meli.magneto.controller.StatsController;
import challenge_meli.magneto.dto.StatsDTO;
import challenge_meli.magneto.service.IStatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StatsControllerTest {

    @InjectMocks
    private StatsController statsController;

    @Mock
    private IStatsService statsService;

    private StatsDTO statsDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        statsDTO = new StatsDTO();
        statsDTO.setCount_mutant_dna(5);
        statsDTO.setCount_human_dna(10);
        statsDTO.setRatio(0.5);
    }

    @Test
    void testGetStats_ReturnsStatsDTO() {
        when(statsService.getStats()).thenReturn(statsDTO);

        StatsDTO response = statsController.getStats();

        assertNotNull(response);
        assertEquals(5, response.getCount_mutant_dna());
        assertEquals(10, response.getCount_human_dna());
        assertEquals(0.5, response.getRatio());


        verify(statsService, times(1)).getStats();
    }
}