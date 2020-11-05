package by.epam.evm.text.data.parser;

public class ParagraphParser extends AbstractParser {
    @Override
    String createSplitter() {
        return "[\\.\\?\\!]";
    }
}
