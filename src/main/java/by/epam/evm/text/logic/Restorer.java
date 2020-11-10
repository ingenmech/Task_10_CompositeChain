package by.epam.evm.text.logic;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Leaf;

import java.util.List;

public class Restorer {

    private final static String WHITESPACE = " ";
    private final static String NEW_LINE = "\n";

    public String restore(Component component) {

        List<Component> text = component.getChildren();
        StringBuilder builder = new StringBuilder();

        for (Component paragraph : text) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component word : sentence.getChildren()) {
                    String tempWord = ((Leaf) word).getValue();
                    builder.append(tempWord);
                    builder.append(WHITESPACE);
                }
            }
            int lastWhitespace = builder.lastIndexOf(WHITESPACE);
            builder.deleteCharAt(lastWhitespace);
            builder.append(NEW_LINE);
        }
        int lastLine = builder.lastIndexOf(NEW_LINE);
        builder.deleteCharAt(lastLine);
        return builder.toString();
    }
}
