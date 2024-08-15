package com.geekbrains.Fam_tree.view.commands;

import com.geekbrains.Fam_tree.view.ConsoleUI;

public class GetInfoCommand extends Command{
    public GetInfoCommand( ConsoleUI consoleUI) {
        super("Получить информацию по объектам семейного дерева", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getInfo();
    }
}
