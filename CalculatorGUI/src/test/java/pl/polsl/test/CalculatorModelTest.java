/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import pl.polsl.model.*;
/**
 *
 * @author mdw18
 */
public class CalculatorModelTest {
        @ParameterizedTest
    @CsvSource({
        "3, 2, +, 5",
        "3, 2, -, 1",
        "3, 2, *, 6",
        "6, 3, /, 2"
    })
    void testValidOperations(double firstNumber, double secondNumber, String operator, double expectedResult) {
        CalculatorModel calculator = new CalculatorModel();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setOperator(operator);

        assertDoesNotThrow(() -> {
            calculator.calculate();
            assertEquals(expectedResult, calculator.getResult(), 0.0001);
        });
    }

    @Test
    void testDivisionByZeroThrowsException() {
        CalculatorModel calculator = new CalculatorModel();
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(0);
        calculator.setOperator("/");

        assertThrows(InvalidArgumentException.class, calculator::calculate, "Expected InvalidArgumentException when dividing by zero");
    }

    @ParameterizedTest
    @CsvSource({
        "3, 2, %",
        "5, 4, ^",
        "7, 8, unknown_operator"
    })
    void testInvalidOperatorsThrowException(double firstNumber, double secondNumber, String operator) {
        CalculatorModel calculator = new CalculatorModel();
        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setOperator(operator);

        assertThrows(InvalidOperatorException.class, calculator::calculate, "Expected InvalidOperatorException for invalid operator");
    }
}
