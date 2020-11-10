package by.epam.evm.text.data.parser;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    protected void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    @Override
    public Component parse(String text) {

        String splitter = createSplitter();
        String[] nodes = text.split(splitter);
        List<Component> components = new ArrayList<>();

        for (String node : nodes) {
            Component component = successor.parse(node);
            components.add(component);
        }
        return new Composite(components);
    }

    public abstract String createSplitter();

}
