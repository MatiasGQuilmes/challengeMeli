Magneto: Detector de ADN Mutante
Descripción del proyecto
Este proyecto implementa una API que permite identificar si una secuencia de ADN pertenece a un mutante o a un humano. La lógica se basa en buscar patrones específicos dentro de una matriz de ADN.

Funcionamiento
El ADN se representa como una matriz de cadenas, donde cada carácter representa una base nitrogenada (A, T, C, G). Para identificar si un ADN es mutante, se verifican las siguientes condiciones:

1- Se deben encontrar al menos dos secuencias de cuatro bases iguales consecutivas en una fila, columna o diagonal.
2- Si se cumple esta condición, el ADN se clasifica como mutante. De lo contrario, es humano.

Ejemplo de ADN mutante: ["ATGCGA",  "CAGTGC",  "TTATGT",  "AGAAGG",  "CCCCTA",  "TCACTG"]

En este caso, hay dos secuencias mutantes:
"AAAA" en una diagonal.
"CCCC" en una columna.


Ejemplo de ADN humano: ["ATGCGA",  "CAGTGC",  "TTATGT",  "AGAAGT",  "CACCTA",  "TCACTG"]



Stack técnico
La aplicación se realizó con:

Java 17.
Spring Boot: Framework para construir la API REST.
Maven: Para la gestión de dependencias y construcción del proyecto.
Thymeleaf: Motor de plantillas para pruebas vía web.
Google Cloud Platform: Hosting de la aplicación.


Instrucciones para ejecutar el programa o API:

Nivel 2: Ejecución local

1- Clonar el repositorio:
git clone https://github.com/MatiasNGonzalezA/challengeMeli.git 

2- Compilar el proyecto: mvn clean install

3- Ejecutar la aplicación: mvn spring-boot:run



Prueba en Postman:


1- Importar la colección: https://api.postman.com/collections/39655576-a43a63ce-329f-4e9c-9efd-d90ee9814cfb?access_key=PMAT-01JD5K6Y49C8QVCZBBAWPRSGJR

2- Metodos:  

  - POST /api/mutant
    
    Ejemplo de mutante:
    {
        "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCACTG"]
    }
    Respuesta: 200 OK.


    Ejemplo de humano:
    {
        "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAGGG", "CCCTTA", "TCACTG"]
    }
    Respuesta: 403 Forbidden.



  - GET /api/stats
    Devuelve estadísticas de la cantidad de mutante, humanos y promedio de mutantes que hay.
    Ejemplo de respuesta:
      {
      "count_mutant_dna": 40,
      "count_human_dna": 100,
      "ratio": 0.4
      }



Pruebas vía Web API
URL de la aplicación:

https://magneto-app-442315.ue.r.appspot.com


En el formulario, ingresa una secuencia de ADN:
Humano:
      ATGCGA, CAGTGC, TTATGT, AGAGGG, CCCTTA, TCACTG
      
Mutante:
      ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCTTA, TCACTG



Notas adicionales
- Se implementó Thymeleaf para crear un formulario sencillo que permite realizar pruebas desde una interfaz web.
- La aplicación utiliza H2 Console como base de datos en memoria para almacenar temporalmente la información.



    
