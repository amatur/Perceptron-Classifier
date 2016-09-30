
import java.util.ArrayList;

public class Example {
    Vector weightVector;
    Integer cls;

    public Example(Vector weightVector, Integer cls) {
        this.weightVector = weightVector;
        this.cls = cls;
    }   

    @Override
    public String toString() {
        return "Example{" + "weightVector=" + weightVector + ", class=" + cls + '}' + "\n";
    }
    
}
