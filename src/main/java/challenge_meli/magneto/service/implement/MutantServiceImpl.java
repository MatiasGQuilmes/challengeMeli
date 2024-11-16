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

        char[][] dnaMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (checkHorizontal(dnaMatrix, i, j) ||
                        checkVertical(dnaMatrix, i, j) ||
                        checkDiagonal(dnaMatrix, i, j)) {
                    sequenceCount++;
                    if (sequenceCount >= AppConstants.MINIMUM_MUTANT_SEQUENCES) {
                        try {

                            saveDnaToDatabase(dna, true);
                        } catch (Exception e) {
                            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
                        }
                        return true; //
                    }
                }
            }
        }

        try {
            saveDnaToDatabase(dna, false);
        } catch (Exception e) {
            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
        }
        return false;
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

    private void saveDnaToDatabase(String[] dna, boolean isMutant) {
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);
        dnaDTO.setMutant(isMutant);

        Dna dnaEntity = dnaMapper.dnaDTOtoEntity(dnaDTO);

        try {
            dnaRepository.save(dnaEntity);
        } catch (Exception e) {
            throw new DatabaseException(AppConstants.ERROR_DATABASE_SAVE, e);
        }
    }
}
