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
        MockitoAnnotations.openMocks(this);

        dnaDTO = new DnaDTO();
        dnaDTO.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
    }

    @Test
    void testIsMutant_Returns200_WhenMutant() {
        when(mutantService.isMutant(dnaDTO.getDna())).thenReturn(true);

        ResponseEntity<Void> response = mutantController.isMutant(dnaDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(mutantService, times(1)).isMutant(dnaDTO.getDna());
    }

    @Test
    void testIsMutant_Returns403_WhenNotMutant() {
        when(mutantService.isMutant(dnaDTO.getDna())).thenReturn(false);

        ResponseEntity<Void> response = mutantController.isMutant(dnaDTO);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        verify(mutantService, times(1)).isMutant(dnaDTO.getDna());
    }

    @Test
    void testDnaDTOConstructor_WithDnaObject() {
        Dna dnaMock = new Dna();
        dnaMock.setDna(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        dnaMock.setMutant(true);

        DnaDTO dto = new DnaDTO(dnaMock);

        assertArrayEquals(dnaMock.getDna(), dto.getDna());
        assertEquals(dnaMock.isMutant(), dto.isMutant());
    }

}