package by.epam.evm.text.logic.sorter;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Sorter {

    public Component sortParagraph(Component component) {

        Comparator<Component> comparator = new ParagraphComparator();
        Component copiedComponent = copy(component);
        List<Component> text = copiedComponent.getChildren();
        text.sort(comparator);
        return new Composite(text);
    }

    //recursion
    private Component copy(Component component) {

        List<Component> children = component.getChildren();
        if (children.isEmpty()) {
            Component leaf = component;
            return leaf;
        }
        List<Component> copiedChildren = new ArrayList<>();
        for (Component child : children) {
            Component copiedChild = copy(child);
            copiedChildren.add(copiedChild);
        }
        return new Composite(copiedChildren);
    }

    public Component sortWord(Component component) {

        Comparator<Component> comparator = new WordComparator();
        List<Component> sortedParagraphs = new ArrayList<>();

        for (Component paragraph : component.getChildren()) {
            List<Component> sortedSentences = new ArrayList<>();

            for (Component sentence : paragraph.getChildren()) {
                Component copiedSentence = copy(sentence);
                List<Component> sortedWords = copiedSentence.getChildren();
                sortedWords.sort(comparator);
                Component sortedSentence = new Composite(sortedWords);
                sortedSentences.add(sortedSentence);
            }
            Component sortedParagraph = new Composite(sortedSentences);
            sortedParagraphs.add(sortedParagraph);
        }
        return new Composite(sortedParagraphs);
    }
}
