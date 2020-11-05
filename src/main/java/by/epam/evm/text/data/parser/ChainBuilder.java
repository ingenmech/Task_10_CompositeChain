package by.epam.evm.text.data.parser;

public class ChainBuilder {

    public Parser build(){

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(new SentenceParser());
        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        return textParser;
    }
}
