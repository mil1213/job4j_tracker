package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(n -> n.subjects().stream())
                .mapToInt(Subject::score)
                .average().orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(n -> new Tuple(n.name(), n.subjects().stream()
                .mapToInt(Subject::score)
                .average().orElse(0)))
                        .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(n -> n.subjects().stream())
                        .collect(Collectors.groupingBy(Subject::name, Collectors.averagingDouble(Subject::score)))
                                .entrySet().stream()
                        .map(t -> new Tuple(t.getKey(), t.getValue()))
                                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(n -> new Tuple(n.name(), n.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .collect(Collectors.maxBy(Comparator.comparing(Tuple::score))).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(n -> n.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::score)))
                .entrySet().stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.maxBy(Comparator.comparing(Tuple::score))).orElse(null);
    }
}
