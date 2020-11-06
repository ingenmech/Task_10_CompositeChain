package by.epam.evm.text.logic.interpreter;

public class ExpressionDivide extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        double firstValue = context.popValue();
        double secondValue = context.popValue();
        double result = firstValue / secondValue;
        context.pushValue(result);
    }
}
