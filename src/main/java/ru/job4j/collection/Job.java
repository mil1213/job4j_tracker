package ru.job4j.collection;

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    @Override
    public int compareTo(Job o) {
        return Integer.compare(priority, o.priority);
    }

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
