package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUlTest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUl.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item exp = new Item("Fix PC") ;
        assertThat(created.getName(), is(exp.getName()));
    }
}