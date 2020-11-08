package by.epam.evm.text.logic;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
            new Composite(Arrays.asList(
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

    @Test
    public void testSortShouldReturnTextWhenDataIsValid() {

        Restorer restorer = new Restorer();
        String actual = restorer.restore(COMPONENT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
