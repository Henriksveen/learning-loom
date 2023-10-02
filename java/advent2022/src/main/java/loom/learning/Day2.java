package loom.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;

public class Day2 {
    private static final char ROCK = 'A';
    private static final char PAPER = 'B';
    private static final char SCISSOR = 'C';

    private static final char _ROCK = 'X';
    private static final char _PAPER = 'Y';
    private static final char _SCISSOR = 'Z';

    private static final char LOOSE = 'X';
    private static final char DRAW = 'Y';
    private static final char WIN = 'Z';

    private static final int S_ROCK = 1;
    private static final int S_PAPER = 2;
    private static final int S_SCISSOR = 3;

    private static final int S_LOOSE = 0;
    private static final int S_DRAW = 3;
    private static final int S_WIN = 6;

    private static final Map<String, Integer> PART_1_STRATEGY_GUIDE = Map.of(
            ROCK + " " + _ROCK, S_DRAW + S_ROCK,
            ROCK + " " + _PAPER, S_WIN + S_PAPER,
            ROCK + " " + _SCISSOR, S_LOOSE + S_SCISSOR,
            PAPER + " " + _ROCK, S_LOOSE + S_ROCK,
            PAPER + " " + _PAPER, S_DRAW + S_PAPER,
            PAPER + " " + _SCISSOR, S_WIN + S_SCISSOR,
            SCISSOR + " " + _ROCK, S_WIN + S_ROCK,
            SCISSOR + " " + _PAPER, S_LOOSE + S_PAPER,
            SCISSOR + " " + _SCISSOR, S_DRAW + S_SCISSOR
    );

    private static final Map<String, Integer> PART_2_STRATEGY_GUIDE = Map.of(
            ROCK + " " + LOOSE, S_LOOSE + S_SCISSOR,
            ROCK + " " + DRAW, S_DRAW + S_ROCK,
            ROCK + " " + WIN, S_WIN + S_PAPER,
            PAPER + " " + LOOSE, S_LOOSE + S_ROCK,
            PAPER + " " + DRAW, S_DRAW + S_PAPER,
            PAPER + " " + WIN, S_WIN + S_SCISSOR,
            SCISSOR + " " + LOOSE, S_LOOSE + S_PAPER,
            SCISSOR + " " + DRAW, S_DRAW + S_SCISSOR,
            SCISSOR + " " + WIN, S_WIN + S_ROCK
    );

    public static void main(String[] args) {
        new Day2().run();
    }

    private void run() {
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
    }

    private int part1() {
        return Arrays.stream(input().split("\n")).
                mapToInt(PART_1_STRATEGY_GUIDE::get)
                .sum();
    }

    private int part2() {
        return Arrays.stream(input().split("\n")).
                mapToInt(PART_2_STRATEGY_GUIDE::get)
                .sum();
    }

    private String input() {
        try {
            return Files.readString(new File("advent2022/src/main/resources/day2.txt").toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String inputTest() {
        return """
                A Y
                B X
                C Z
                """;
    }
}
