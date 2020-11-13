package by.epam.evm.text.data.parser;

import by.epam.evm.text.model.Component;
import by.epam.evm.text.model.Composite;
import by.epam.evm.text.model.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class TextParserTest {

    private final static String TEXT = "Word [expression] word.\nWord expression word.";
    private final static Component EXPECTED = new Composite(Arrays.asList(
            Leaf.word("Word [expression] word."),
            Leaf.word("Word expression word.")));

    @Test
    public void testParseShouldReturnComponentWhenDataIsValid() {
        //given
        Parser paragraphParser = Mockito.mock(ParagraphParser.class);
        when(paragraphParser.parse(anyString())).thenAnswer(invocation -> Leaf.word(invocation.getArgument(0)));
        Parser textParser = new TextParser(paragraphParser);
        //when
        Component actual = textParser.parse(TEXT);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
