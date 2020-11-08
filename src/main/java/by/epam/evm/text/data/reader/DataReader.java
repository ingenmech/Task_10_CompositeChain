package by.epam.evm.text.data.reader;

public interface DataReader {
    String read(String fileName) throws DataException;
}
