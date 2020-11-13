package by.epam.evm.text.data.parser;

public class TextParser extends AbstractParser {

    private final static String SPLITTER = "[A-Z].*";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public String createPattern() {
        return SPLITTER;
    }
}
