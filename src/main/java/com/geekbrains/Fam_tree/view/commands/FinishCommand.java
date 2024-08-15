package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class FinishCommand extends Command{


    public FinishCommand(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
