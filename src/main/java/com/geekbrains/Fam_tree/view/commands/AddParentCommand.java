package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class AddParentCommand extends Command{


    public AddParentCommand( ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}
