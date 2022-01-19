package com.company.frog;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    protected int position;
    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        int newPosition = position + steps;
        if (newPosition < MIN_POSITION || newPosition > MAX_POSITION)
            return false;
        else {
            position = newPosition;
            return true;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = MIN_POSITION; i < MAX_POSITION + 1; i++) {
            if (position == i)
                sb.append("x");
            else
                sb.append("-");
        }
        return sb.toString();
    }
}
