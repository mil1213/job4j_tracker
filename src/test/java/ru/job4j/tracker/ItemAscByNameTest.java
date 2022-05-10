package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemAscByNameTest {

    @Test
    public void whenSortAsc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Anton"),
                new Item(3, "Sergey"),
                new Item(4, "Boris")
        );
        List<Item> expected = Arrays.asList(
                items.get(1), items.get(3), items.get(0), items.get(2));
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortDesc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Anton"),
                new Item(3, "Sergey"),
                new Item(4, "Boris")
        );
        List<Item> expected = Arrays.asList(
                items.get(2), items.get(0), items.get(3), items.get(1));
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}