package days;

import common.FileInput;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day3 {
    private final FileInput fileInput = new FileInput();

    public static void main(String[] args) {
        new Day3().run();
    }

    private void run() {
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
    }

    private IntStream getPriorities(String s) {
//        return s.chars().map(x -> x >= 'a' && x <= 'z' ? x - 'a' + 1 : x - 'A' + 26 + 1);
        return s.chars().map(x -> x <= 'Z' ? x - 'A' + 26 + 1 : x - 'a' + 1);
    }

    private Integer part1() {
        return input()
                .map(e -> new String[]{e.substring(0, e.length() / 2), e.substring(e.length() / 2)})
                .mapToInt(r -> getPriorities(r[0]).filter(i -> getPriorities(r[1]).anyMatch(j -> j == i)).findFirst().getAsInt())
                .sum();
    }

    private Integer part2() {
        String[] s = input().toArray(String[]::new);
        return IntStream.range(0, s.length / 3)
                .map(x -> x * 3)
                .map(x -> getPriorities(s[x]).filter(i -> getPriorities(s[x + 1]).anyMatch(j -> j == i) && getPriorities(s[x + 2]).anyMatch(j -> j == i)).findFirst().getAsInt())
                .sum();
    }

    private Stream<String> input() {
        return fileInput.read("day3.txt").lines();
    }


    private String inputTest() {
        return """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                """;
    }
}
