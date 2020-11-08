package by.epam.evm.text.data.reader;

import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {

    private final static String FILE_NAME = "src/test/resources/testReader.txt";
    private final static String EXPECTED = "It has survived - not only (five) centuries.";

    @Test
    public void testReadShouldReturnStringWhenDataIsCorrect() throws DataException {
        DataReader reader = new FileDataReader();

        String actual = reader.read(FILE_NAME);

        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = DataException.class)
    public void testReadShouldReturnExceptionWhenDataNotExist() throws DataException {
        DataReader reader = new FileDataReader();

        reader.read("src/test/resources/notExist.txt");
    }
}
