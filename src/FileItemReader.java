public interface FileItemReader extends ItemReader{
    public void open(String path);
    public CsvItemReader.ItemQuantity readItem();
    public String[] readHeader();
    public void close();
}
