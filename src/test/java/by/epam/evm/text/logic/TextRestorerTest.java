package by.epam.evm.text.logic;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextRestorerTest {

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

        TextRestorer restorer = new TextRestorer();
        String actual = restorer.restore(COMPONENT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
