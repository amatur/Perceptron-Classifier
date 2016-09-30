import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class PerceptronFileRead extends FileRead{
    public ArrayList<Example> examples;    
    public PerceptronFileRead(String file, ArrayList<Example> examples) {
        super(file);
        this.examples = examples;
    }
    
    @Override
     public void processLine(String line){       
         Scanner s = new Scanner(line);
        //s.useDelimiter("\\s");
         ArrayList<Double> wv = new ArrayList<>();
         while(s.hasNext()){             
             //System.out.println(s.nextDouble());
             wv.add(s.nextDouble());
         }
         int cls = (int) Math.floor(wv.remove(wv.size()-1));
         examples.add(new Example(new Vector(wv), cls));
    }
    
}
