package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSixMinusZeroEqualsSix() {
        // Arrange
        int firsOperand = 6;
        int secondOperand = 0;
        int expectedResult = 6;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusSixMinusZeroEqualsSix() {
        // Arrange
        int firsOperand = -6;
        int secondOperand = 0;
        int expectedResult = -6;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSixMinusThreeEqualsThree() {
        // Arrange
        int firsOperand = 6;
        int secondOperand = 3;
        int expectedResult = 3;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSixMinusMinusThreeEqualsNine() {
        // Arrange
        int firsOperand = 6;
        int secondOperand = -3;
        int expectedResult = 9;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusSixMinusThreeEqualsMinusNine() {
        // Arrange
        int firsOperand = -6;
        int secondOperand = 3;
        int expectedResult = -9;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusSixMinusMinusThreeEqualsMinusThree() {
        // Arrange
        int firsOperand = -6;
        int secondOperand = -3;
        int expectedResult = -3;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureOverfowResultsInException() {
        // Arrange
        int firsOperand = -2147483648;
        int secondOperand = 10;

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().subtract(firsOperand, secondOperand);
        });
    }

    @Test
    public void ensureTenDividedByTwoEquals5() {
        // Arrange
        int firsOperand = 10;
        int secondOperand = 2;
        int expectedResult = 5;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureTenDividedByThreeEquals3() {
        // Arrange
        int firsOperand = 10;
        int secondOperand = 3;
        int expectedResult = 3;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureTenDividedByMinusTwoEqualsMinusFive() {
        // Arrange
        int firsOperand = 10;
        int secondOperand = -2;
        int expectedResult = -5;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureTenDividedByMinusThreeEqualsMinusThree() {
        // Arrange
        int firsOperand = 10;
        int secondOperand = -3;
        int expectedResult = -3;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusTenDividedByMinusTwoEqualsFive() {
        // Arrange
        int firsOperand = -10;
        int secondOperand = -2;
        int expectedResult = 5;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusTenDividedByThreeEqualsMinusThree() {
        // Arrange
        int firsOperand = -10;
        int secondOperand = 3;
        int expectedResult = -3;

        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureDivisonByZeroResultsInArithmeticException() {
        // Arrange
        int firsOperand = 10;
        int secondOperand = 0;

        // Act and Assert
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new Calculator().divide(firsOperand, secondOperand);
        });
    }
    @Test
    public void ensureFactorialFiveIsOnehundrertwenty() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 5;

        int expectedResult = 120;
        int result = 3;

        // Act
        result = new Calculator().factorial(firsOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureFactorialNegativeFive() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{new Calculator().factorial(-5);});
    }
    @Test
    public void ensureFactorialZeroIsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;

        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().factorial(firsOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureFactorialOneIsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 1;

        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().factorial(firsOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureFactorialNegativeOne() {
       Assertions.assertThrows(IllegalArgumentException.class, () ->{new Calculator().factorial(-1);});
        }

    @Test
    public void ensureFiveTimesFiveEqualsTwentyFive() {
        // Arrange
        int firsOperand = 5;
        int secondOperand = 5;
        int expectedResult = 25;

        // Act
        int result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureFiveTimesMinusFiveEqualsMinusTwentyFive() {
        // Arrange
        int firsOperand = 5;
        int secondOperand = -5;
        int expectedResult = -25;

        // Act
        int result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusFiveTimesMinusFiveEqualsTwentyFive() {
        // Arrange
        int firsOperand = -5;
        int secondOperand = -5;
        int expectedResult = 25;

        // Act
        int result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureOverflowResultsInIllegalArgumentException() {
        // Arrange
        int firsOperand = 2147483647;
        int secondOperand = 2;

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().multiply(firsOperand, secondOperand);
        });
    }

}



