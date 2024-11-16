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
    private IDnaRepository dnaRepository;  // Mock del repositorio

    @InjectMocks
    private StatsServiceImpl statsService;  // Servicio al que se le inyectará el mock

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializamos los mocks
    }

    @Test
    public void testGetStats() {
        // Configuramos los valores mockeados del repositorio
        when(dnaRepository.countByIsMutant(true)).thenReturn(40);  // 40 mutantes
        when(dnaRepository.countByIsMutant(false)).thenReturn(60); // 60 humanos

        // Ejecutamos el método
        StatsDTO statsDTO = statsService.getStats();

        // Verificamos que los valores son los esperados
        assertEquals(40, statsDTO.getCountMutantDNA());
        assertEquals(60, statsDTO.getCountHumanDNA());
        assertEquals(0.6667, statsDTO.getRatio(), 0.0001);  // Aproximadamente 40/60
    }
}
