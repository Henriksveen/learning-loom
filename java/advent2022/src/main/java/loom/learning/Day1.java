package loom.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.LongStream;


public class Day1 {
    public static void main(String[] args) {
        new Day1().run();
    }

    private void run() {
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
    }

    private Long part1() {
        return input().max().getAsLong();
    }

    private Long part2() {
        long[] nums = input().sorted().toArray();
        return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
    }

    private LongStream input() {
        return Arrays.stream(
                inputDay1().split("\n\n")).mapToLong(
                elf -> elf.lines().mapToLong(Long::parseLong).sum()
        );
    }

    private String inputDay1() {
        try {
            return Files.readString(new File("advent2022/src/main/resources/day1.txt").toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String inputTest() {
        return """
                1000
                2000
                3000
                                
                4000
                                
                5000
                6000
                                
                7000
                8000
                9000
                                
                10000
                """;
    }
}
