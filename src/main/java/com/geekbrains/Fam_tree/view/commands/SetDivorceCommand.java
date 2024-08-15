package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class SetDivorceCommand extends Command{


    public SetDivorceCommand( ConsoleUI consoleUI) {
        super("Развод", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setDivorce();

    }
}
