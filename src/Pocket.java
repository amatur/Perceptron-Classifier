import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Pocket {

    double learnRate; //ro
    Vector weightVector;
    double bias = 1;
    int UPPER_LIMIT = 5;

    public Pocket(double initialLearnRate, ArrayList<Example> examples) {

        Random rand = new Random();
        this.learnRate = initialLearnRate;
        Vector storedVector = null;
        int history  = 0;
        //start training

        try {
            Double arr[] = {-1000.0, 12.0, 10.0};
            this.weightVector = new Vector(arr);
            storedVector = new Vector(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int t = 0;

        int correctlyClassified;
        /*set of misclassified examples*/
        Set<Example> Y;
        do {

            Y = new HashSet<>();
            for (int i = 0; i < examples.size(); i++) {
                Example x = examples.get(i);
                //System.out.println(delx(x.cls)*Vector.dot(x.weightVector, this.weightVector));
                if (delx(x.cls) * Vector.dot(x.featureVector, this.weightVector) >= 0) {
                    Y.add(x);
                }
            }
            Vector summ = new Vector(weightVector.size());  //empty vector, 0, 0, 0 

            for (Example x : Y) {
                summ.add(Vector.multiply(x.featureVector, delx(x.cls)));
            }

            //System.out.println();
            this.weightVector.sub(Vector.multiply(summ, learnRate));
            //adjust learnrate

            t = t + 1;
            //learnRate = 10/(t);
            System.out.println(this.weightVector);
            
            correctlyClassified = examples.size() - Y.size();
            //pocket-keeping
            if(correctlyClassified > history){
                history = correctlyClassified;
                storedVector = new Vector(this.weightVector);
            }

        } while (correctlyClassified<examples.size() && t<UPPER_LIMIT);
        if(t==UPPER_LIMIT){
            this.weightVector = storedVector;
        }
        
        System.out.println("No. of iterations:" + (t));
        System.out.println(this.weightVector + "\nMissclassified: "  +  (examples.size()-history));
    }

    private int delx(int cls) {
        if (cls == 1) {
            return -1; //if class is w1, wTx > 0, so delx is -1  
        } else {
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
