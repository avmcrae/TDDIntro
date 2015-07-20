package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Factorial can only be computed with a non-negative number.");
        }

        else if (i == 0) {
            return 1;
        }

        Integer factorial = 1;
        while (i > 1) {
            factorial = factorial * i;
            i--;
        }
        return factorial;
    }
}
