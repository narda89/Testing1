package it.euris.ires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}