package pt.ipp.isep.dei.examples.tdd.basic.domain;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        long result = (long) firstOperand - (long) secondOperand;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int) result;
    }

    public int divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    public int multiply(int firstOperand, int secondOperand) {
        long result = (long) firstOperand * (long) secondOperand;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int) result;
    }

    public int factorial(int firstOperand) {
        throw new UnsupportedOperationException();
    }
}
