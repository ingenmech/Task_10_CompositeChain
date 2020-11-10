package by.epam.evm.text.data.parser;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class TextParserTest {

    private final static String TEXT = "Word [expression] word.\nWord [expression] word.";
    private final static Component EXPECTED = new Composite(Arrays.asList(
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[expression]"),
                            Leaf.word("word."))
                    ))
            ),
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[expression]"),
                            Leaf.word("word."))
                    ))
            )

    ));

    private final static Component PARAGRAPH = new Composite(Collections.singletonList(
            new Composite(Arrays.asList(
                    Leaf.word("Word"),
                    Leaf.expression("[expression]"),
                    Leaf.word("word."))
            ))
    );

    @Test
    public void testParseShouldReturnComponentWhenDataIsValid() {
        //given
        AbstractParser paragraphParser = Mockito.mock(ParagraphParser.class);
        when(paragraphParser.parse(anyString())).thenReturn(PARAGRAPH).thenReturn(PARAGRAPH);
        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);
        //when
        Component actual = textParser.parse(TEXT);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
