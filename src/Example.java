

public class Example {
    Vector featureVector;
    Integer cls;

    public Example(Vector weightVector, Integer cls) {
        this.featureVector = weightVector;
        this.cls = cls;
    }   

    @Override
    public String toString() {
        return "Example{" + "featureVector=" + featureVector + ", class=" + cls + '}' + "\n";
    }
    
}
