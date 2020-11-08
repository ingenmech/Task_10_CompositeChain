package by.epam.evm.text.logic.sorter;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TODO Think about immutable copy
public class Sorter {

    public Component sortParagraph(Component component) {

        List<Component> text = component.getChildren();
        Comparator comparator = new ParagraphComparator();
        text.sort(comparator);
        Component sortedComponent = new Composite(text);

        return copy(sortedComponent);
    }

    public Component sortWord(Component component) {

        Comparator comparator = new WordComparator();
        List<Component> sortedParagraph = new ArrayList<>();

        for (Component paragraph : component.getChildren()) {
            List<Component> sortedWords = new ArrayList<>();
            for (Component sentence : paragraph.getChildren()) {
                sortedWords = sentence.getChildren();
                sortedWords.sort(comparator);
            }
            Component sortedComponent = new Composite(sortedWords);
            sortedParagraph.add(sortedComponent);
        }

        return new Composite(sortedParagraph);
    }

    //recursion
    private Component copy(Component component) {

        List<Component> children = component.getChildren();
        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return leaf;
        }
        List<Component> copiedChildren = new ArrayList<>();
        for (Component child : children) {
            Component copiedChild = copy(child);
            copiedChildren.add(copiedChild);
        }
        return new Composite(copiedChildren);
    }
}
