package by.epam.evm.text.data.parser;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    public AbstractParser() {
    }

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    @Override
    public Component parse(String text) {

        String patternValue = createPattern();
        Pattern pattern = Pattern.compile(patternValue);
        Matcher matcher = pattern.matcher(text);
        List<Component> components = new ArrayList<>();

        while (matcher.find()) {
            String node = matcher.group();
            Component component = successor.parse(node);
            components.add(component);
        }
        return new Composite(components);
    }

    public abstract String createPattern();
}
