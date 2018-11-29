public class Door {

    private boolean isClosed;

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        isClosed = true;
    }

    public void open() {
        isClosed = false;
    }
}
