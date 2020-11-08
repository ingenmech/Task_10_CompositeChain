package by.epam.evm.text.model;

import java.util.ArrayList;
import java.util.List;

public final class Leaf implements Component {

    private final LeafType type;
    private final String value;

    private Leaf(LeafType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Leaf expression(String value) {
        return new Leaf(LeafType.EXPRESSION, value);
    }

    public static Leaf word(String value) {
        return new Leaf(LeafType.WORD, value);
    }

    public LeafType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        if (type != leaf.type) {
            return false;
        }
        return value != null ? value.equals(leaf.value) : leaf.value == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leaf{type=" + type + ", value='" + value + '\'' + '}';
    }


}
