package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionExampleTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionExample function = new FunctionExample();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenResults() {
        FunctionExample function = new FunctionExample();
        List<Double> result = function.diapason(2, 5, x -> 2 * x * x + 3 * x + 1);
        List<Double> expected = Arrays.asList(15D, 28D, 45D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenResults() {
        FunctionExample function = new FunctionExample();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}