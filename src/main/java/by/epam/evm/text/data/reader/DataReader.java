package by.epam.evm.text.data.reader;

import by.epam.evm.text.data.DataException;

public interface DataReader {
    String read(String fileName) throws DataException;
}
