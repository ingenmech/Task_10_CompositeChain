package by.epam.evm.text.data.parser;

public class TextParser extends AbstractParser {

    private final static String SPLITTER = "\n";

    @Override
    public String createSplitter() {
        return SPLITTER;
    }
}
