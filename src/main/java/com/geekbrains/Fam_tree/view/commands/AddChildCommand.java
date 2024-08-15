package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class AddChildCommand extends Command{


    public AddChildCommand( ConsoleUI consoleUI) {
        super("Добавить ребёнка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}
