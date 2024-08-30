package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class LoadToFile extends Command{
    public LoadToFile( ConsoleUI consoleUI) {
        super("Загрузка из файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadFromFile();
    }
}
