package by.epam.evm.text.data.parser;

//TODO change split without delete lexeme . ! ?
public class ParagraphParser extends AbstractParser {
    @Override
    String createSplitter() {
        return "[\\.\\?\\!]";
    }
}
