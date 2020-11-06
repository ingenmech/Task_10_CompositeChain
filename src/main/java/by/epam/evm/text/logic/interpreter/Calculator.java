package by.epam.evm.text.logic.interpreter;

import by.epam.evm.text.data.component.Component;
import by.epam.evm.text.data.component.Composite;
import by.epam.evm.text.data.component.Leaf;
import by.epam.evm.text.data.component.LeafType;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final static String SPLITTER = "_";
    private final static String ANY_DIGIT = "\\d+";

    public Component calculate(Component root) {

        List<Component> calculatedComponents = new ArrayList<>();
        List<Component> components = root.getComponents();

        for (Component component : components) {
            if (components.size() > 0) {
                // recursion
                Component calculatedComponent = calculate(component);
                calculatedComponents.add(calculatedComponent);
            } else if (((Leaf) component).getType() == LeafType.EXPRESSION) {
                Component calculatedComponent = calculateExpression(((Leaf) component));
                calculatedComponents.add(calculatedComponent);
            } else {
                calculatedComponents.add(component);
            }
        }

        return new Composite(components);
    }

    private Leaf calculateExpression(Leaf expression) {

        Context context = new Context();
        String expressionValue = expression.getValue();
        List<AbstractExpression> expressions = parse(expressionValue);

        for (AbstractExpression element : expressions) {
            element.interpret(context);
        }
        Double result = context.popValue();
        String value = result.toString();
        return new Leaf(LeafType.WORD, value);
    }


    private List<AbstractExpression> parse(String expression) {

        List<AbstractExpression> expressions = new ArrayList<>();
        String[] lexemes = expression.split(SPLITTER);

        for (String lexeme : lexemes) {

            switch (lexeme) {
                case "+":
                    expressions.add(new ExpressionPlus());
                    break;
                case "-":
                    expressions.add(new ExpressionMinus());
                    break;
                case "*":
                    expressions.add(new ExpressionMultiply());
                    break;
                case "/":
                    expressions.add(new ExpressionDivide());
                    break;
                default:
                    if (lexeme.matches(ANY_DIGIT)) {
                        int number = Integer.parseInt(lexeme);
                        expressions.add(new ExpressionNumber(number));
                    }
            }
        }
        return expressions;
    }


}
