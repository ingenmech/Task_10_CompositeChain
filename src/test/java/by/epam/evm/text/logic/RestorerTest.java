package by.epam.evm.text.logic;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class RestorerTest {

    private final static String EXPECTED = "Word [expression] word. Word word!\nWord [expression] word?";
    private final static Component COMPONENT = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[expression]"),
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
                            Leaf.expression("[expression]"),
                            Leaf.word("word?"))
                    ))
            )
    ));

    @Test
    public void testRestoreShouldReturnTextWhenDataIsValid() {

        Restorer restorer = new Restorer();
        String actual = restorer.restore(COMPONENT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
