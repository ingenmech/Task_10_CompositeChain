package by.epam.evm.text.data.parser;

public class TextParser extends AbstractParser {

    private final static String SPLITTER = "\n";

    public TextParser() {
    }

    //package-private for test
    TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public String createSplitter() {
        return SPLITTER;
    }
}
