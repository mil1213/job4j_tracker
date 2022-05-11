package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        int rsl = new JobAscByName().compare(new Job("clear", 1), new Job("delete", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        int rsl = new JobAscByPriority().compare(new Job("clear", 2), new Job("delete", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        int rsl = new JobDescByName().compare(new Job("clear", 1), new Job("delete", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        int rsl = new JobDescByPriority().compare(new Job("clear", 2), new Job("delete", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityThenByName() {
        Comparator<Job> ascPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = ascPriorityName.compare(new Job("clear", 2), new Job("clone", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 0),
                new Job("Fix", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}