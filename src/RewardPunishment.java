
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
public class RewardPunishment {

    double learnRate; //ro
    Vector weightVector;
    double bias = 1;

    public RewardPunishment(double initialLearnRate, ArrayList<Example> examples) {

        
        this.learnRate = initialLearnRate;
        try {
            Double arr[] = {-1000.0, 12.0, 10.0};
            this.weightVector = new Vector(arr);
            System.err.println(weightVector);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int t = 0;

        int correct;
        do {
            correct = 0;
            for (int i = 0; i < examples.size(); i++) {
                Example x = examples.get(i);
                
                if ((x.cls)==1 && Vector.dot(x.featureVector, this.weightVector) <= 0) {
                    //punish by adding
                    this.weightVector.add(Vector.multiply(x.featureVector, this.learnRate));
                }else if((x.cls)==2 && Vector.dot(x.featureVector, this.weightVector) >= 0){
                    //punish by subtracting
                    this.weightVector.sub(Vector.multiply(x.featureVector, this.learnRate));
                }else{
                    //reward, remains the same
                    correct++;
                }
            }
     
            t = t + 1;
            System.out.println(this.weightVector);

        } while (correct<examples.size());

        System.out.println("No. of iterations:" + t);
        //this.weightVector = weightVector;
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
