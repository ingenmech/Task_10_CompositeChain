package by.epam.evm.text.logic.interpreter;

public class NumberExpression implements AbstractExpression {

    private final double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
