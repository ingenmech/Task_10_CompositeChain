package by.epam.evm.text.logic.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

// package-private
class Context {

    private final Deque<Double> values = new ArrayDeque<>();

    public Double popValue() {
        return values.pop();
    }

    public void pushValue(Double value) {
        values.push(value);
    }
}
