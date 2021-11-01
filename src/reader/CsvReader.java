package reader;

public interface CsvReader<T>{
    void open(String path);
    T read();
    String[] readHeader();
    void close();
}
