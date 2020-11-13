package by.epam.evm.text.data.parser;

public class ParagraphParser extends AbstractParser {

    private final static String SENTENCE = "[A-Z].*?[.!?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public String createPattern() {
        return SENTENCE;
    }
}
