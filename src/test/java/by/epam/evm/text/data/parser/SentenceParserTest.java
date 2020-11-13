package by.epam.evm.text.data.parser;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    private final static Component EXPECTED_COMPONENT = new Composite(Arrays.asList(
            Leaf.word("Word"),
            Leaf.expression("[expression]"),
            Leaf.word("word?")
    ));

    private final static String TEXT = "Word [expression] word?";

    @Test
    public void testParseShouldReturnComponentWhenDataIsValid() {
        //given
        Parser sentenceParser = new SentenceParser();
        //when
        Component actual = sentenceParser.parse(TEXT);
        //then
        Assert.assertEquals(EXPECTED_COMPONENT, actual);
    }
}
