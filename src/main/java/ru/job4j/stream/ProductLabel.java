package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {

        return products.stream()
                .filter(n -> (n.getStandard() - n.getActual()) >= 0)
                .filter(n -> (n.getStandard() - n.getActual()) <= 3)
                .map(n -> new Label(n.getName(), (n.getPrice() * 0.5f)))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}
