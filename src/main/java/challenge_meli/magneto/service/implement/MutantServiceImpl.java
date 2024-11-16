package challenge_meli.magneto.service.implement;

import challenge_meli.magneto.constant.AppConstants;
import challenge_meli.magneto.dto.DnaDTO;
import challenge_meli.magneto.exception.DatabaseException;
import challenge_meli.magneto.exception.InvalidDnaException;
import challenge_meli.magneto.model.Dna;
import challenge_meli.magneto.repository.IDnaRepository;
import challenge_meli.magneto.service.IMutantService;
import challenge_meli.magneto.service.mapper.IDnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements IMutantService {

    @Autowired
    private IDnaRepository dnaRepository;

    @Autowired
    private IDnaMapper dnaMapper;


    @Override
    public boolean isMutant(String[] dna) {
        if (dna == null || dna.length == 0) {
            throw new InvalidDnaException(AppConstants.ERROR_INVALID_DNA);
        }

        int sequenceCount = 0;
        int n = dna.length;

        // Convertir la matriz de ADN en una matriz bidimensional de caracteres
        char[][] dnaMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }

        // Recorrer cada posición de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Verificar si se encuentra una secuencia de 4 iguales en las tres direcciones
                if (checkHorizontal(dnaMatrix, i, j) ||
                        checkVertical(dnaMatrix, i, j) ||
                        checkDiagonal(dnaMatrix, i, j)) {
                    sequenceCount++;
                    if (sequenceCount >= AppConstants.MINIMUM_MUTANT_SEQUENCES) {
                        try {
                            // Guardar el ADN en la base de datos después de determinar que es mutante
                            saveDnaToDatabase(dna, true);
                        } catch (Exception e) {
                            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
                        }
                        return true; // Retorna true si se encuentran más de una secuencia
                    }
                }
            }
        }

        try {
            // Guardar el ADN en la base de datos después de determinar que no es mutante
            saveDnaToDatabase(dna, false);
        } catch (Exception e) {
            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
        }

        return false; // Retorna false si no se encuentran suficientes secuencias
    }

    private boolean checkHorizontal(char[][] dna, int row, int col) {
        int n = dna.length;
        if (col + AppConstants.SEQUENCE_LENGTH - 1 < n) {
            return dna[row][col] == dna[row][col + 1] &&
                    dna[row][col] == dna[row][col + 2] &&
                    dna[row][col] == dna[row][col + 3];
        }
        return false;
    }

    private boolean checkVertical(char[][] dna, int row, int col) {
        int n = dna.length;
        if (row + AppConstants.SEQUENCE_LENGTH - 1 < n) {
            return dna[row][col] == dna[row + 1][col] &&
                    dna[row][col] == dna[row + 2][col] &&
                    dna[row][col] == dna[row + 3][col];
        }
        return false;
    }

    private boolean checkDiagonal(char[][] dna, int row, int col) {
        int n = dna.length;
        if (row + AppConstants.SEQUENCE_LENGTH - 1 < n && col + AppConstants.SEQUENCE_LENGTH - 1 < n) {
            return dna[row][col] == dna[row + 1][col + 1] &&
                    dna[row][col] == dna[row + 2][col + 2] &&
                    dna[row][col] == dna[row + 3][col + 3];
        }
        return false;
    }

    // Método para guardar el ADN en la base de datos usando el mapper
    private void saveDnaToDatabase(String[] dna, boolean isMutant) {
        // Convertir el ADN y el estado de mutante en un DTO
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);
        dnaDTO.setMutant(isMutant);

        // Usar el mapper para convertir el DTO a una entidad
        Dna dnaEntity = dnaMapper.dnaDTOtoEntity(dnaDTO);

        try {
            // Guardar la entidad en la base de datos
            dnaRepository.save(dnaEntity);
        } catch (Exception e) {
            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
        }
    }
}
