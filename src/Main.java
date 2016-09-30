import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    static int NUM_TRAINING_ROW = 5000;
    static int ROW_EACH_ITER = 500;
    static int NUM_ITERATIONS = 10;

    static String trainFile = "./assignment1/train1.txt";
    static String testFile = "./assignment1/test1.txt";
    static String trainFileKesler = "./assignment1/train_kesler.txt";
    static String testFileKesler = "./assignment1/train_kesler.txt";
    
    
    public static void main(String[] args) {
        ArrayList<Example> trainExamples = new ArrayList<>(); 
        new PerceptronFileRead(trainFile, trainExamples).processFile(2, null);
        System.out.println(trainExamples);
        PerceptronClassifier pc = new PerceptronClassifier(0.1, trainExamples);
        
    }

}
