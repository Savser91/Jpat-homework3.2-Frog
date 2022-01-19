package com.company;

import com.company.frog.Frog;
import com.company.frogCommands.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int curCommand = -1;
        System.out.println("Введите команду из списка: \n" +
                "+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");
        while (true) {
            String input = scanner.nextLine();

            if ("0".equals(input))
                break;

            if ("<<".equals(input)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (">>".equals(input)) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else if ("!!".equals(input)) {
                if (curCommand == commands.size() - 1 && curCommand != -1) {
                    commands.add(commands.get(curCommand));
                    curCommand++;
                    commands.get(curCommand).doit();
                } else {
                    System.out.println("Нечего повторять");
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    for (int i = 0; i < commands.size(); i++) {
                        commands.remove(i);
                    }
                }
                int steps = Integer.parseInt(input);
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, steps);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
            }
            System.out.println(frog);
        }
    }
}
