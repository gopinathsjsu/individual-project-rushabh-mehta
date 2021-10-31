public interface CsvReader<T>{
    public void open(String path);
    public T read();
    public String[] readHeader();
    public void close();
}
