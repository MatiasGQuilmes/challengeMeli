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
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Configurar un objeto StatsDTO de prueba
        statsDTO = new StatsDTO();
        statsDTO.setCountMutantDNA(5);
        statsDTO.setCountHumanDNA(10);
        statsDTO.setRatio(0.5);
    }

    @Test
    void testGetStats_ReturnsStatsDTO() {
        // Preparar el mock
        when(statsService.getStats()).thenReturn(statsDTO);

        // Ejecutar el método del controlador
        StatsDTO response = statsController.getStats();

        // Verificar el resultado
        assertNotNull(response);
        assertEquals(5, response.getCountMutantDNA());
        assertEquals(10, response.getCountHumanDNA());
        assertEquals(0.5, response.getRatio());

        // Verifica que se haya llamado al método de servicio
        verify(statsService, times(1)).getStats();
    }
}