package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUl {
    private final Output out;

    public StartUl(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0.." + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("MENU:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(output), new ShowAllActions(output),
                new EditAction(output), new DeleteAction(output), new FindActionByID(output),
                new FindActionByName(output), new Exit());
        new StartUl(output).init(input, tracker, actions);
    }
}
