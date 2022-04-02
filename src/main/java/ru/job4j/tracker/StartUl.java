package ru.job4j.tracker;

public class StartUl {
    private final Output out;

    public StartUl(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("MENU:");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ShowAllActions(output),
                new EditAction(output), new DeleteAction(output), new FindActionByID(output),
                new FindActionByName(output), new Exit()};
        new StartUl(output).init(input, tracker, actions);
    }
}
