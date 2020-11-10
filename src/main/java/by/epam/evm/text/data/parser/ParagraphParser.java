package by.epam.evm.text.data.parser;

public class ParagraphParser extends AbstractParser {

    private final static String SPLITTER = "\\s\\s";

    @Override
    public String createSplitter() {
        return SPLITTER;
    }
}
