public interface FileItemReader extends ItemReader{
    public void open(String path);
    public String next();
    public void close();
}
