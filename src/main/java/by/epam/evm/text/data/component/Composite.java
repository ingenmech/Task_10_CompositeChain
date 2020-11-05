package by.epam.evm.text.data.component;

import java.util.List;

public class Composite implements Component {

    private final List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {

    }
}
