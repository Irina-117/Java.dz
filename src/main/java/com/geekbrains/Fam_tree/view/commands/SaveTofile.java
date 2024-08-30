package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class SaveTofile extends Command{
    public SaveTofile(ConsoleUI consoleUI) {
        super("Сохранить в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveToFile();
    }
}
