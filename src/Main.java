import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
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
        final ArrayList<Example> trainExamples = new ArrayList<>(); 
        ArrayList<Example> testExamples = new ArrayList<>(); 
        
        new PerceptronFileRead(trainFile, trainExamples).processFile(2, null);
        new PerceptronFileRead(testFile, testExamples).processFile();
        
        System.out.println(trainExamples);
        
       // PerceptronClassifier PC = new PerceptronClassifier(1000, trainExamples);
              //  RewardPunishment PC = new RewardPunishment(2, trainExamples);
 Pocket PC = new Pocket(2, trainExamples);
        System.out.println("Accuracy: "+ PC.test(testExamples));
        
    }

}
