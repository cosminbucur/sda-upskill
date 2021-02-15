package com.sda.functional.method_reference.constructor;


import java.util.Arrays;
import java.util.List;

interface Robot {

    Command execute(String order);
}

public class DemoConstructor {

    public static void main(String[] args) {
        // method reference to a constructor
        Robot oldRobot = string -> new Command(string);
        Robot robot = Command::new;
        robot.execute("REBOOT");

        List<String> commandLines = Arrays.asList("JUMP", "PUNCH", "SHOOT");

        // old school
        for (String item : commandLines) {
            System.out.println(new Command(item));
        }

        // convert string to object
        commandLines.stream()
                .map(Command::new)
                .forEach(System.out::println);
    }
}

class Command {

    private String commandLine;

    public Command(String commandLine) {
        this.commandLine = commandLine;
        System.out.println("command line: " + commandLine);
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandLine='" + commandLine + '\'' +
                '}';
    }
}