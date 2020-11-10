package by.epam.evm.text.logic.sorter;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Leaf;

import java.util.Comparator;

public class WordComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstLeaf, Component secondLeaf) {

        String firstWord = ((Leaf) firstLeaf).getValue();
        String secondWord = ((Leaf) secondLeaf).getValue();
        int firstSize = firstWord.length();
        int secondSize = secondWord.length();
        int result = 0;

        if (firstSize > secondSize) {
            result = 1;
        } else if (firstSize < secondSize) {
            result = -1;
        }
        return result;
    }
}
