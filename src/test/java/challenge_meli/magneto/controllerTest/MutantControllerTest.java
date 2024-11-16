package challenge_meli.magneto.controllerTest;

import challenge_meli.magneto.controller.MutantController;
import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.model.Dna;
import challenge_meli.magneto.service.IMutantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MutantControllerTest {

    @InjectMocks
    private MutantController mutantController;

    @Mock
    private IMutantService mutantService;

    private DnaDTO dnaDTO;

    @BeforeEach
    void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Configurar el DTO de ADN de prueba
        dnaDTO = new DnaDTO();
        dnaDTO.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
    }

    @Test
    void testIsMutant_Returns200_WhenMutant() {
        // Preparar el mock
        when(mutantService.isMutant(dnaDTO.getDna())).thenReturn(true);

        // Ejecutar el método del controlador
        ResponseEntity<Void> response = mutantController.isMutant(dnaDTO);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(mutantService, times(1)).isMutant(dnaDTO.getDna()); // Verifica que se haya llamado al método
    }

    @Test
    void testIsMutant_Returns403_WhenNotMutant() {
        // Preparar el mock
        when(mutantService.isMutant(dnaDTO.getDna())).thenReturn(false);

        // Ejecutar el método del controlador
        ResponseEntity<Void> response = mutantController.isMutant(dnaDTO);

        // Verificar el resultado
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        verify(mutantService, times(1)).isMutant(dnaDTO.getDna()); // Verifica que se haya llamado al método
    }

    @Test
    void testDnaDTOConstructor_WithDnaObject() {
        // Configura un objeto Dna de prueba
        Dna dnaMock = new Dna();
        dnaMock.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        dnaMock.setMutant(true);

        // Instancia DnaDTO usando el constructor que toma un Dna
        DnaDTO dto = new DnaDTO(dnaMock);

        // Verifica que los campos de DnaDTO se hayan inicializado correctamente
        assertArrayEquals(dnaMock.getDna(), dto.getDna());
        assertEquals(dnaMock.isMutant(), dto.isMutant());
    }

}