package by.epam.evm.text.data.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private final List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    @Override
    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }
}
