package by.epam.evm.text.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private final List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return components != null ? components.equals(composite.components) : composite.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Composite{components=" + components + '}';
    }
}
