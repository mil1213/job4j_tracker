package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUlTest {
/*
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new Exit()};
        new StartUl().init(in, tracker, actions);
        assertEquals(tracker.findAll()[0].getName(), "Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String id = Integer.toString(item.getId());
        String replacedName = "New Item name";
        Input in = new StubInput(new String[]{"0", id, replacedName, "1"});
        UserAction[] actions = {new EditAction(), new Exit()};
        new StartUl().init(in, tracker, actions);
        assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        UserAction[] actions = {new DeleteAction(), new Exit()};
        new StartUl().init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }
*/
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUl(out).init(in, tracker, actions);
        assertThat(out.toString(), is("MENU:" + System.lineSeparator() + "0. Exit" + System.lineSeparator()));
    }
}