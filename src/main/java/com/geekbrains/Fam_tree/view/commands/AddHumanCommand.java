package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class AddHumanCommand extends Command {


    public AddHumanCommand( ConsoleUI consoleUI) {
        super("Добавить объект в семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}
