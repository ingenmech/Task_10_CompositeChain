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

    @Override
    public Component parse(String text) {

        String[] nodes = text.split("");
        List<Component> components = new ArrayList<>();

        for (String node : nodes) {
            LeafType type = (isExpression(node)) ? LeafType.EXPRESSION : LeafType.WORD;
            Leaf leaf = new Leaf(type, node);
            components.add(leaf);
        }

        return new Composite(components);
    }

    private boolean isExpression(String word) {

        Pattern pattern = Pattern.compile("^\\[.*\\]$");
        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
