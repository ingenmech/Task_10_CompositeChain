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

    private final static String TEXT = "Word expression word. Word word word.";
    private final static Component EXPECTED = new Composite(Arrays.asList(
            Leaf.word("Word expression word."),
            Leaf.word("Word word word.")
            ));

    @Test
    public void testParseShouldReturnComponentWhenDataIsValid() {
        //given
        Parser sentenceParser = Mockito.mock(SentenceParser.class);
        when(sentenceParser.parse(anyString())).thenAnswer(invocation -> Leaf.word(invocation.getArgument(0)));
        Parser parser = new ParagraphParser(sentenceParser);
        //when
        Component actual = parser.parse(TEXT);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
