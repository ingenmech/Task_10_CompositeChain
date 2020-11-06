package by.epam.evm.text.logic.interpreter;

public class ExpressionNumber extends AbstractExpression {

    private double number;

    public ExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }

}
