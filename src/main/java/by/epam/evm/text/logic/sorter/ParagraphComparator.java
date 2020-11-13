package by.epam.evm.text.logic.sorter;

import by.epam.evm.text.model.Component;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {

        int firstSize = firstComponent.getChildren().size();
        int secondSize = secondComponent.getChildren().size();
        int result = 0;

        if (firstSize > secondSize) {
            result = 1;
        } else if (firstSize < secondSize) {
            result = -1;
        }
        return result;
    }
}
