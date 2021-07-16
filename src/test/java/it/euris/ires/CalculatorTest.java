package it.euris.ires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("GIVEN add(a,b) WHEN a equals 1 AND b equals 2 THEN expected result is 3")
    void add() {
        // arrange
        int numberA = 1;
        int numberB = 2;
        int expectedResult = 3;
        // act
        int result = calculator.add(numberA,numberB);
        // assert
        assertEquals(expectedResult, result, String.format("%s + %s should equal %s", numberA, numberB, expectedResult));
    }

    @Test
    @DisplayName("GIVEN subtract(a,b) WHEN a equals 1 AND b equals 2 THEN expected result is -1")
    void subtract() {
        // arrange
        int numberA = 1;
        int numberB = 2;
        int expectedResult = -1;
        // act
        int result = calculator.subtract(numberA,numberB);
        // assert
        assertEquals(expectedResult, result, String.format("%s - %s should equal %s", numberA, numberB, expectedResult));
    }

    @Test
    @DisplayName("GIVEN multiply(a,b) WHEN a equals 3 AND b equals 4 THEN expected result is 12")
    void multiply() {
        // arrange
        int numberA = 3;
        int numberB = 4;
        int expectedResult = 12;
        // act
        int result = calculator.multiply(numberA,numberB);
        // assert
        assertEquals(expectedResult, result, String.format("%s * %s should equal %s", numberA, numberB, expectedResult));
    }

    @Test
    @DisplayName("GIVEN divide(a,b) WHEN a equals 6 AND b equals 2 THEN expected result is 3 ")
    void divide() {
        // arrange
        int numberA = 6;
        int numberB = 2;
        int expectedResult = 3;
        // act
        int result = calculator.divide(numberA,numberB);
        // assert
        assertEquals(expectedResult, result, String.format("%s / %s should equal %s", numberA, numberB, expectedResult));
    }


    @ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenAddThenShouldReturn {2}")
    @CsvSource({
            "0,1,1",
            "0,-1,-1",
            "-50,50,0",
            Integer.MAX_VALUE +", "+ Integer.MAX_VALUE +", -2"
    })
    void addWithBvaValues(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first +" 0 "+ second +" should equal "+ expectedResult );
    }

    @ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenSubtractThenShouldReturn {2}")
    @CsvSource({
            "0,1,-1",
            "0,-1,1",
            Integer.MAX_VALUE +", "+ Integer.MAX_VALUE +", 0",
            Integer.MAX_VALUE +", "+ Integer.MIN_VALUE +", -1",
            Integer.MIN_VALUE +", 1, "+ Integer.MAX_VALUE
    })
    void subWithBvaValues(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.subtract(first, second),
                () -> first +" 0 "+ second +" should equal "+ expectedResult );
    }

    @ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenMultiplyThenShouldReturn {2}")
    @CsvSource({
            "0,1,0",
            "1,0,0",
            "2,3,6",
            "1,-1,-1",
            "-1,1,-1",
            "-1,-1,1",
            Integer.MAX_VALUE +", "+ Integer.MAX_VALUE +", 0",
            Integer.MIN_VALUE +", "+ Integer.MIN_VALUE +", 0", // ok, oscilla tra 0 ( * 2k) e MIN_VALUE ( * 2k+1)
            Integer.MIN_VALUE +", 3,0",
            Integer.MIN_VALUE +", 4,0",
            Integer.MIN_VALUE +", 5,0",
            Integer.MIN_VALUE +", 6,0",
            Integer.MIN_VALUE +", 1, "+ Integer.MAX_VALUE
    })
    void multiplyWithBvaValues(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.multiply(first, second),
                () -> first +" 0 "+ second +" should equal "+ expectedResult );
    }

    @ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenDivideThenShouldReturn {2}")
    @CsvSource({
            "0,1,0",
            "0,-1,0",
            "1,-1,-1",
            "-1,-1,1",
            Integer.MAX_VALUE +", 1, "+ Integer.MAX_VALUE,
            Integer.MIN_VALUE +", 1, "+ Integer.MIN_VALUE,
            Integer.MIN_VALUE +", "+ Integer.MAX_VALUE +", -1",
    })
    void divideWithBvaValues(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.divide(first, second),
                () -> first +" 0 "+ second +" should equal "+ expectedResult );
    }


}