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
    private final static String WORD_PATTERN = "\\S+";

    @Override
    public Component parse(String text) {

        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        List<Component> components = new ArrayList<>();

        while (matcher.find()) {
            String node = matcher.group();
            Leaf component = (isExpression(node)) ? Leaf.expression(node) : Leaf.word(node);
            components.add(component);
        }
        return new Composite(components);
    }

    private boolean isExpression(String word) {
        Pattern pattern = Pattern.compile(EXPRESSION);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    @Override
    public String createPattern() {
        return WORD_PATTERN;
    }
}
