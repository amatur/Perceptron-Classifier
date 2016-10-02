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
    static String testFileKesler = "./assignment1/test_kesler.txt";
    
    
    public static void main(String[] args) {
        final ArrayList<Example> trainExamples = new ArrayList<>(); 
        final ArrayList<Example> testExamples = new ArrayList<>(); 
        final ArrayList<Example> trainKesler = new ArrayList<>(); 
        final ArrayList<Example> testKesler = new ArrayList<>(); 
        
        
        new PerceptronFileRead(trainFile, trainExamples).processFile(2, null);
        new PerceptronFileRead(testFile, testExamples).processFile();
        PerceptronFileRead keslerTrainFile = new PerceptronFileRead(trainFileKesler, trainKesler);
        keslerTrainFile.processFile(2, null);
        keslerTrainFile.countClasses();
        new PerceptronFileRead(testFileKesler, testKesler).processFile();
        
        
        
        //System.out.println(trainExamples);
        
        /*** Normal perceptron***/
        ///*
        //for bias add extra 1
        for(Example ex: trainExamples){
            ex.featureVector.appendExtra1();
        }
        
        //for bias add extra 1
        for(Example ex: testExamples){
            ex.featureVector.appendExtra1();
        }
        
        for(Example ex: trainKesler){
            ex.featureVector.appendExtra1();
        }
        
        //for bias add extra 1
        for(Example ex: testKesler){
            ex.featureVector.appendExtra1();
        }
        //PerceptronClassifier PC = new PerceptronClassifier(1000, trainExamples);
        
        //  RewardPunishment PC = new RewardPunishment(2, trainExamples);
        // Pocket PC = new Pocket(2, trainExamples);
        //System.out.println("Accuracy: "+ PC.test(testExamples));
        //*/
        
        System.out.println(keslerTrainFile.uniqueClasses);
        Kesler kesler = new Kesler(1, trainKesler, keslerTrainFile.uniqueClasses.size());
        System.out.println("Accuracy: "+ kesler.test(testKesler));
  //      System.out.println(Vector.concat(trainExamples.get(0).featureVector, trainExamples.get(1).featureVector));
        
    }
}
