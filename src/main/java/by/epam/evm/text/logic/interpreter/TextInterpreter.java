package by.epam.evm.text.logic.interpreter;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;
import by.epam.evm.text.model.LeafType;

import java.util.ArrayList;
import java.util.List;

// think about
public class TextInterpreter {

    private final static String SPLITTER = "_";
    private final static String ANY_DIGIT = "\\d+";
    private final static String IDENTIFIER = "\\[|\\]";
    private final static String EMPTY = "";

    // recursion
    public Component interpret(Component component) {

        List<Component> children = component.getChildren();
        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return interpretExpression(leaf);
        }
        List<Component> calculatedComponents = new ArrayList<>();
        for (Component child : children) {
            Component calculatedComponent = interpret(child);
            calculatedComponents.add(calculatedComponent);
        }
        return new Composite(calculatedComponents);
    }

    private Leaf interpretExpression(Leaf expression) {

        if (expression.getType() != LeafType.EXPRESSION) {
            return expression;
        }
        Context context = new Context();
        String expressionValue = expression.getValue();
        List<AbstractExpression> expressions = parse(expressionValue);

        for (AbstractExpression element : expressions) {
            element.interpret(context);
        }
        Double result = context.popValue();
        String value = result.toString();

        return Leaf.word(value);
    }

    private List<AbstractExpression> parse(String expression) {

        String value = expression.replaceAll(IDENTIFIER, EMPTY);
        List<AbstractExpression> expressions = new ArrayList<>();
        String[] lexemes = value.split(SPLITTER);

        for (String lexeme : lexemes) {

            switch (lexeme) {
                case "+":
                    expressions.add(new PlusExpression());
                    break;
                case "-":
                    expressions.add(new MinusExpression());
                    break;
                case "*":
                    expressions.add(new MultiplyExpression());
                    break;
                case "/":
                    expressions.add(new DivideExpression());
                    break;
                default:
                    if (ANY_DIGIT.matches(lexeme)) {
                        int number = Integer.parseInt(lexeme);
                        expressions.add(new NumberExpression(number));
                    }
            }
        }
        return expressions;
    }
}
