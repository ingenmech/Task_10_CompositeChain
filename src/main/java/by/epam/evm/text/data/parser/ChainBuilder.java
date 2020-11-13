package by.epam.evm.text.data.parser;

public class ChainBuilder {

    public Parser build() {
        Parser sentenceParser = new SentenceParser();
        Parser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}
