
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tasnim
 */
public class PerceptronClassifier {

    double learnRate; //ro
    Vector weightVector;
    double bias = 1;

    public PerceptronClassifier(double initialLearnRate, ArrayList<Example> examples, Vector v) {

        Random rand = new Random();
        this.learnRate = initialLearnRate;
        try {
            //Double arr[] = {-1000.0, 12.0, 10.0};
            //
            if(v!=null){
                this.weightVector = v;
            }else{
                this.weightVector = new Vector(examples.get(0).featureVector.size());
            }
                
            System.err.println(weightVector);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int t = 0;

        /*set of misclassified examples*/
        Set<Example> Y;
        do {

            Y = new HashSet<>();
            for (int i = 0; i < examples.size(); i++) {
                Example x = examples.get(i);
                //System.out.println(delx(x.cls)*Vector.dot(x.featureVector, this.weightVector));
                if (delx(x.cls) * Vector.dot(x.featureVector, this.weightVector) >= 0) {
                    Y.add(x);
                                 //       System.out.println("TRUE");

                }else{
                  //  System.out.println("FALSE");
                }
            }
            Vector sum = new Vector(weightVector.size());  //empty vector, 0, 0, 0 

            for (Example x : Y) {
                sum.add(Vector.multiply(x.featureVector, delx(x.cls)));
            }

            //System.out.println();
            this.weightVector.sub(Vector.multiply(sum, learnRate));
            //adjust learnrate

            t = t + 1;
            //System.err.println("Missclassified:    " +  Y.size());
            //learnRate = 10/(t);
            System.out.println(this.weightVector);

        } while (!Y.isEmpty());

        System.out.println("No. of iterations:" + t);
        this.weightVector = weightVector;
    }

    private int delx(int cls) {
        if (cls == 1) {
            //System.err.println("111111");
            return -1; //if class is w1, wTx > 0, so delx is -1  
        } else {
            //System.err.println("22222222");
            return 1;
        }
    }

    /**
     * *
     *
     * @param testList List of examples to test.
     * @return Accuracy of the test set.
     */
    public double test(ArrayList<Example> Example) {
        //start testing
        int correct = 0;
        int wrong = 0;

        for (Example testEx : Example) {
            if (test(testEx) == testEx.cls) {
                correct++;
            } else {
                wrong++;
            }
        }
        double accuracy = (correct * 1.0) / (correct + wrong) * 100;
        return accuracy;
    }

    /**
     *
     * @param testExample
     * @return Class it belongs to
     */
    public int test(Example testExample) {
        if (Vector.dot(weightVector, testExample.featureVector) > 0) {
            return 1;
        } else {
            return 2;
        }
    }

}
