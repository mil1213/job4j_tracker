package ru.job4j.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMapP {
    public static double averageScore(List<PupilL> pupils) {
        double sumScore = 0;
        int count = 0;
        for (var i : pupils) {
            for (var j : i.subjects()) {
                sumScore += j.getScore();
               count += 1;
            }
        }
        double rsl = sumScore / count;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<PupilL> pupils) {
        double sumScore = 0;
        List<Label> labelsPupil = new ArrayList<>();
        for (var i : pupils) {
            for (var j : i.subjects()) {
                sumScore += j.getScore();
            }
            labelsPupil.add(new Label(i.name(), sumScore / i.subjects().size()));
            sumScore = 0;
        }
        return labelsPupil;
    }

    public static List<Label> averageScoreBySubject(List<PupilL> pupils) {
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (var i : pupils) {
            for (var j : i.subjects()) {
                tempMap.merge(j.getName(), j.getScore(), (oldV, newV) -> oldV + newV);
            }
        }
        List<Label> labelsSubjects = new ArrayList<>();
        for (var i : tempMap.entrySet()) {
            labelsSubjects.add(new Label(i.getKey(), i.getValue() / pupils.size()));
        }
        return labelsSubjects;
    }

    public static Label bestStudent(List<PupilL> pupils) {
        double sumScore = 0;
        List<Label> labelsPupil = new ArrayList<>();
        for (var i : pupils) {
            for (var j : i.subjects()) {
                sumScore += j.getScore();
            }
            labelsPupil.add(new Label(i.name(), sumScore));
            sumScore = 0;
        }
        labelsPupil.sort(Label::compareTo);
        return labelsPupil.get(labelsPupil.size() - 1);
    }

    public static Label bestSubject(List<PupilL> pupils) {
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (var i : pupils) {
            for (var j : i.subjects()) {
                tempMap.merge(j.getName(), j.getScore(), (oldV, newV) -> oldV + newV);
            }
        }
        List<Label> labelsSubjects = new ArrayList<>();
        for (var i : tempMap.entrySet()) {
            labelsSubjects.add(new Label(i.getKey(), i.getValue()));
        }
        labelsSubjects.sort(Label::compareTo);
        return labelsSubjects.get(labelsSubjects.size() - 1);
    }
}
