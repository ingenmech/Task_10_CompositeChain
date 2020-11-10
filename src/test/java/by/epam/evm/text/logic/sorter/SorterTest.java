package by.epam.evm.text.logic.sorter;

import by.epam.evm.text.component.Component;
import by.epam.evm.text.component.Composite;
import by.epam.evm.text.component.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SorterTest {

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
    private final static Component EXPECTED_PARAGRAPH = new Composite(Arrays.asList(
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[expression]"),
                            Leaf.word("word?"))
                    ))
            ),
            new Composite(Arrays.asList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.expression("[expression]"),
                            Leaf.word("word."))),
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word!"))
                    ))
            )
    ));
    private final static Component EXPECTED_WORD = new Composite(Arrays.asList(
            new Composite(Arrays.asList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word."),
                            Leaf.expression("[expression]"))
                    ),
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word!"))
                    ))
            ),
            new Composite(Collections.singletonList(
                    new Composite(Arrays.asList(
                            Leaf.word("Word"),
                            Leaf.word("word?"),
                            Leaf.expression("[expression]"))
                    ))
            )
    ));

    @Test
    public void testSortParagraphShouldReturnSortedTextByParagraphWhenDataIsCorrect() {

        Sorter sorter = new Sorter();
        //when
        Component actual = sorter.sortParagraph(COMPONENT);
        //then
        Assert.assertEquals(EXPECTED_PARAGRAPH, actual);
    }

    @Test
    public void testSortWordShouldReturnSortedTextByWordInSentenceWhenDataIsCorrect() {

        Sorter sorter = new Sorter();
        //when
        Component actual = sorter.sortWord(COMPONENT);
        //then
        Assert.assertEquals(EXPECTED_WORD, actual);
    }
}
