package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        }

    @Test
    public void whenInvalidInputTrue() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"4"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));
    }

    @Test
    public void whenInvalidInputTrueSeveralTimes() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "4"});
        int[] test = {1, 4};
        int[] rsl = new int[test.length];
        for (int i = 0; i < test.length; i++) {
            ValidateInput input = new ValidateInput(out, in);
            rsl[i] = input.askInt("Enter menu:");
        }
        assertThat(rsl, is(test));
    }

    @Test
    public void whenInvalidInputNegative() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"-4"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-4));
    }
}

