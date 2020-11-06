package by.epam.evm.text.data.parser;

import by.epam.evm.text.data.component.Component;
import by.epam.evm.text.data.component.Composite;
import by.epam.evm.text.data.component.Leaf;
import by.epam.evm.text.data.component.LeafType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    private final static String IDENTIFIER = "\\[|\\]";
    private final static String EMPTY = "";
    private final static String EXPRESSION = "^\\[.*\\]$";
    private final static String WHITESPACE = " ";

    @Override
    public Component parse(String text) {

        String[] nodes = text.split(WHITESPACE);
        List<Component> components = new ArrayList<>();

        for (String node : nodes) {
            LeafType type = (isExpression(node)) ? LeafType.EXPRESSION : LeafType.WORD;
            String expression = node.replaceAll(IDENTIFIER, EMPTY);
            Leaf leaf = new Leaf(type, expression);
            components.add(leaf);
        }

        return new Composite(components);
    }

    private boolean isExpression(String word) {

        Pattern pattern = Pattern.compile(EXPRESSION);
        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
