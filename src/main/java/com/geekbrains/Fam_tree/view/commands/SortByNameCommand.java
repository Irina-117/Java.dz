package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class SortByNameCommand extends Command{

    public SortByNameCommand(ConsoleUI consoleUI){
        super("Отсортировать по имени",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
    }
}
