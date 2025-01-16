package design_pattern.command;

import java.util.Stack;

public class CommandPatternPractice {

    public static void main(String[] args) {

        Invoker invoker = new Invoker(new TurnOnCommand(), new TurnOffCommand());
        invoker.turnOn();
        invoker.turnOff();
        invoker.undoTurnOn();
        invoker.undoTurnOff();
    }
}

class  Invoker {
    final Stack<ICommand> commands;
    final ICommand turnOnCommand;
    final ICommand turnOffCommand;

    Invoker(ICommand turnOnCommand, ICommand turnOffCommand) {
        this.turnOnCommand = turnOnCommand;
        this.turnOffCommand = turnOffCommand;
        this.commands = new Stack<>();
    }

    void turnOn(){
        turnOnCommand.execute();
        commands.push(turnOnCommand);
    }

    void turnOff(){
        turnOffCommand.execute();
        commands.push(turnOffCommand);
    }

    void undoTurnOn(){
        turnOnCommand.unExecute();
        commands.pop();
    }

    void undoTurnOff(){
        turnOffCommand.unExecute();
        commands.pop();
    }
}


interface  ICommand {
    void execute();

    void unExecute();
}


class TurnOnCommand implements ICommand {
    String name;

    @Override
    public void execute() {
        name = "TurnOnCommand Execute";
        System.out.println("TurnOnCommand Execute");
    }

    @Override
    public void unExecute() {
        name = "TurnOnCommand Un-Execute";
        System.out.println("TurnOnCommand Un-Execute");
    }

    @Override
    public String toString() {
        return "TurnOnCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}

class TurnOffCommand implements ICommand {
    String name;

    @Override
    public void execute() {
        name = "TurnOffCommand Execute";
        System.out.println("TurnOffCommand Execute");
    }

    @Override
    public void unExecute() {
        name = "TurnOffCommand Un-Execute";
        System.out.println("TurnOffCommand Un-Execute");
    }

    @Override
    public String toString() {
        return "TurnOffCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
