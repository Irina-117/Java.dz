package com.geekbrains.Fam_tree.view;

import com.geekbrains.Fam_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands=new ArrayList<>();
        commands.add( new AddHumanCommand(consoleUI));
        commands.add(new SetWeddingCommand(consoleUI));
        commands.add(new SetDivorceCommand(consoleUI));
        commands.add( new AddChildCommand(consoleUI));
        commands.add(new AddParentCommand(consoleUI));
        commands.add(new SortByNameCommand(consoleUI));
        commands.add(new SortByAgeCommand(consoleUI));
        commands.add(new GetInfoCommand(consoleUI));
        commands.add(new SaveTofile(consoleUI));
        commands.add(new LoadToFile(consoleUI));
        commands.add(new FinishCommand(consoleUI));
    }
    public String menu(){
        StringBuilder sb=new StringBuilder();
        sb.append("Список команд:\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command= commands.get(choice-1);
        command.execute();
    }
    public int size(){
        return commands.size();
    }

}
