package by.epam.evm.text.data.parser;

public class ChainBuilder {

    public Parser build() {

        AbstractParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(new SentenceParser());

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);
        return textParser;
    }
}
