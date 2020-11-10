package by.epam.evm.text.data.parser;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    private final static String TEXT = "Word [expression] word.  Word [expression] word.";
    private final static Component EXPECTED = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    Leaf.word("Word"),
                    Leaf.expression("[expression]"),
                    Leaf.word("word."))
            ),
            new Composite(Arrays.asList(
                    Leaf.word("Word"),
                    Leaf.expression("[expression]"),
                    Leaf.word("word."))
            )

    ));

    private final static Component COMPONENT = new Composite(Arrays.asList(
            Leaf.word("Word"),
            Leaf.expression("[expression]"),
            Leaf.word("word.")
    ));

    @Test
    public void testParseShouldReturnComponentWhenDataIsValid() {
        //given
        AbstractParser sentenceParser = Mockito.mock(SentenceParser.class);
        when(sentenceParser.parse(anyString())).thenReturn(COMPONENT).thenReturn(COMPONENT);
        AbstractParser parser = new ParagraphParser();
        parser.setSuccessor(sentenceParser);
        //when
        Component actual = parser.parse(TEXT);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
