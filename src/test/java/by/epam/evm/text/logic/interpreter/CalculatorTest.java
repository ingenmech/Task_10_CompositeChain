package by.epam.evm.text.logic.interpreter;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CalculatorTest {

    private final static Component EXPECTED_TEXT = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("30.0"),
                            Leaf.word("word."))
                    ),
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word!"))
                    ))
            ),
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("3.0"),
                            Leaf.word("word?"))
                    ))
            )
    ));
    private final static Component COMPONENT = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[5_5_+_3_*]"),
                            Leaf.word("word."))
                    ),
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word!"))
                    ))
            ),
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[2_2_-_3_+]"),
                            Leaf.word("word?"))
                    ))
            )
    ));

    @Test
    public void testCalculateShouldReturnTextWithCalculatedExpressionWhenDataIsValid(){

        Calculator calculator = new Calculator();

        Component actualText = calculator.calculate(COMPONENT);

        Assert.assertEquals(EXPECTED_TEXT, actualText);
    }
}
