package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class SetWeddingCommand extends Command{
    public SetWeddingCommand( ConsoleUI consoleUI) {
        super("Свадьба", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setWedding();
    }
}
