package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class SortByAgeCommand extends Command{

    public SortByAgeCommand(ConsoleUI consoleUI){
        super("Отсортировать по возрасту",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
