package by.epam.evm.text.data.parser;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private final static String EXPRESSION = "^\\[.*\\]$";
    private final static String WHITESPACE = "\\s";

    public SentenceParser() {
    }

    @Override
    public Component parse(String text) {

        String[] nodes = text.split(WHITESPACE);
        List<Component> components = new ArrayList<>();

        for (String node : nodes) {
            Leaf leaf = (isExpression(node)) ? Leaf.expression(node) : Leaf.word(node);
            components.add(leaf);
        }
        return new Composite(components);
    }

    private boolean isExpression(String word) {

        Pattern pattern = Pattern.compile(EXPRESSION);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    @Override
    public String createSplitter() {
        return "isNotSplitter";
    }
}
