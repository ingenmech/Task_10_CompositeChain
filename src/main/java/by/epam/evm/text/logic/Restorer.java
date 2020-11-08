package by.epam.evm.text.logic;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Leaf;

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
            builder.append("\n");
        }
        int lastLine = builder.lastIndexOf(NEW_LINE);
        builder.deleteCharAt(lastLine);
        return builder.toString();
    }

    //recursion
    public String restoreRecursion(Component component) {

        List<Component> children = component.getChildren();
        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            String value = leaf.getValue();
            return value.concat(WHITESPACE);
        }
        StringBuilder builder = new StringBuilder();
        for (Component child : children) {
            String node = restore(child);
            builder.append(node);
        }
        return builder.toString();
    }

//    public String restoreCickle(Component component) {
//
//        List<Component> children = component.getChildren();
//        StringBuilder builder = new StringBuilder();
//        for (Component child: children){
//            String paragraph = restore(child);
//            builder.append(paragraph);
//            builder.append("\n");
//        }
//        return builder.toString();
//    }


}
