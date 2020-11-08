package by.epam.evm.text.data.parser;

public class ParagraphParser extends AbstractParser {

    private final static String SPLITTER = "\\s\\s";

    public ParagraphParser() {
    }

    //package-private for test
    ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public String createSplitter() {
        return SPLITTER;
    }
}
