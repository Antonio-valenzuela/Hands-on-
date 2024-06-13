public abstract class DataSet {
    private String[] elements;

    public DataSet(String[] elements) {
        this.elements = elements;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public abstract void displayData();
}
