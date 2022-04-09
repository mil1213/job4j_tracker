package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUlTest {

    @Test
     public void whenCreateItem() {
         Output out = new StubOutput();
         Input in = new StubInput(new String[]{"0", "Item name", "1"});
         Tracker tracker = new Tracker();
         UserAction[] actions = {new CreateAction(out), new Exit()};
         new StartUl(out).init(in, tracker, actions);
         assertThat(tracker.findAll()[0].getName(), is("Item name"));
     }

     @Test
     public void whenReplaceItem() {
         Output out = new StubOutput();
         Tracker tracker = new Tracker();
         Item item = tracker.add(new Item("Replaced item"));
         String id = Integer.toString(item.getId());
         String replacedName = "New Item name";
         Input in = new StubInput(new String[]{"0", id, replacedName, "1"});
         UserAction[] actions = {new EditAction(out), new Exit()};
         new StartUl(out).init(in, tracker, actions);
         assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
     }

     @Test
     public void whenDeleteItem() {
         Output out = new StubOutput();
         Tracker tracker = new Tracker();
         Item item = tracker.add(new Item("Deleted item"));
         String id = Integer.toString(item.getId());
         Input in = new StubInput(new String[]{"0", id, "1"});
         UserAction[] actions = {new DeleteAction(out), new Exit()};
         new StartUl(out).init(in, tracker, actions);
         assertNull(tracker.findById(item.getId()));
     }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUl(out).init(in, tracker, actions);
        assertThat(out.toString(), is("MENU:" + System.lineSeparator() + "0. Exit"
                + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replacedName = "New Item name";
        Input in = new StubInput(new String[]{"0", String.valueOf(one.getId()), replacedName, "1"});
        UserAction[] actions = {new EditAction(out), new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
        + "0. Edit Item" + ln
        + "1. Exit" + ln
        + "=== Edit item ===" + ln
        + "Item has been replaced successfully" + ln
        + "MENU:" + ln + "0. Edit Item" + ln + "1. Exit" + ln
        ));
    }

    @Test
    public void whenShowAllActionsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item second = tracker.add(new Item("test2"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {new ShowAllActions(out), new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Show all items ===" + ln
                + one + ln
                + second + ln
                + "MENU:" + ln + "0. Show all items" + ln + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindActionByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{"0", one.getName(), "1"});
        UserAction[] actions = {new FindActionByName(out), new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln
                + "=== Find items by name ===" + ln
                + one + ln
                + "MENU:" + ln + "0. Find items by name" + ln + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindActionByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{"0", String.valueOf(one.getId()), "1"});
        UserAction[] actions = {new FindActionByID(out), new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "MENU:" + ln + "0. Find item by id" + ln + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindActionByIdTestOutputIsNotSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[]{"0", "100", "1"});
        UserAction[] actions = {new FindActionByID(out), new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + "Item with id = 100 is not found" + ln
                + "MENU:" + ln + "0. Find item by id" + ln + "1. Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{"8", "0"});
        UserAction[] actions = {new Exit()};
        new StartUl(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("MENU:" + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0..0" + ln
                + "MENU:" + ln
                + "0. Exit" + ln
        ));
    }
}