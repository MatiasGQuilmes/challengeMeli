package challenge_meli.magneto.constant;

public class AppConstants {

    // Mensajes de error
    public static final String ERROR_INVALID_DNA = "El ADN proporcionado no puede ser nulo o vacío.";
    public static final String ERROR_DATABASE_SAVE = "Error al intentar guardar el ADN en la base de datos.";
    public static final String ERROR_MUTANT_DETECTION = "Hubo un error al intentar detectar el ADN mutante.";

    // Mensajes de éxito
    public static final String SUCCESS_MUTANT_DETECTED = "Mutante detectado exitosamente.";
    public static final String SUCCESS_HUMAN_DETECTED = "Humano detectado exitosamente.";

    // Otras constantes
    public static final int SEQUENCE_LENGTH = 4;  // Longitud de la secuencia de ADN
    public static final int MINIMUM_MUTANT_SEQUENCES = 2; // Mínimo de secuencias mutantes para considerar un ADN como mutante

    public static final String SPRING_DATASOURCE_URL = "jdbc:h2:mem:testdb";

    public static final String SPRING_DATASOURCE_DRIVERCLASSNAME = "org.h2.Driver";

    public static final String SPRING_DATASOURCE_USERNAME = "sa";
    public static final String SPRING_DATASOURCE_PASSWORD = "password";

    public static final String SPRING_DATASOURCE_INITMODE = "always";

}

