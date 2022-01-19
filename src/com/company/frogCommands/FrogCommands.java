package com.company.frogCommands;

import com.company.frog.Frog;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doit() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(steps * -1);
            }
        };
    }
}
