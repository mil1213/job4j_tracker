package ru.job4j.tracker;

import java.util.List;

public class ShowAllActions implements UserAction {
    private final Output out;

    public ShowAllActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        //Item[] items = tracker.findAll();
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("There is nothing in Tracker");
        }
        return true;
    }
}
