package days;

import common.FileInput;

import java.util.Arrays;
import java.util.stream.LongStream;


public class Day1 {
    private final FileInput fileInput = new FileInput();

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
                fileInput.read("day1.txt").split("\n\n")).mapToLong(
                elf -> elf.lines().mapToLong(Long::parseLong).sum()
        );
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
