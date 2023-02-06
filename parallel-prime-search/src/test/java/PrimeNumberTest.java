import org.example.PrimeNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrimeNumberTest {

    @Test
    void test_calculateNPremierNumberWithOutThreads_donneUnNombre_alorsRetourneLaListeDesNombresPremiersJusquauNombre() {
        // When
        List<Integer> listOfPremierNumber = PrimeNumber.calculateNPrimeNumberWithOutThreads(10);

        // Then
        Assertions.assertEquals(List.of(2,3,5,7),listOfPremierNumber);
    }

    @Test
    void test_calculateNPremierNumberWithTwoThreads_donneUnNombre_alorsRetourneLaListeDesNombresPremiersJusquauNombre() throws InterruptedException {
        // When
        List<Integer> listOfPremierNumber = PrimeNumber.calculateNPrimeNumberWithTwoThreads(10);

        // Then
        Assertions.assertEquals(List.of(2,3,5,7),listOfPremierNumber);
    }
}
