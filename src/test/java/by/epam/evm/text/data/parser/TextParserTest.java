package by.epam.evm.text.data.parser;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class TextParserTest {

    private final static Component COMPONENT = new Composite(Arrays.asList(
            Leaf.word("Word"),
            Leaf.expression("[expression]"),
            Leaf.word("word."),
            Leaf.word("Word"),
            Leaf.word("word!"),
            Leaf.word("Word"),
            Leaf.expression("[expression]"),
            Leaf.word("word?")
    ));

    private final static String TEXT = "Word [expression] word.  Word word!\nWord [expression] word?";
    private final static Component EXPECTED = new Composite(Arrays.asList(
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
    public void testParseShouldReturnComponentWhenDataIsValid() {

        //Mockito.mock(WordParser.class);
        //when(wordParser.parse(anyString())).thenReturn(COMPONENT);
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        //when(paragraphParser.parse(anyString())).thenReturn(EXPECTED);
        TextParser textParser = new TextParser(paragraphParser);

        Component actual = textParser.parse(TEXT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
