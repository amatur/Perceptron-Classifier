
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

    public PerceptronClassifier(double initialLearnRate, ArrayList<Example> examples) {

    Random rand = new Random();
        this.learnRate = initialLearnRate;
        try {
            Double arr[] = {rand.nextDouble(), rand.nextDouble(), rand.nextDouble()};
            this.weightVector = new Vector(arr);
            System.err.println(weightVector);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int t = 0;
        
        /*set of misclassified examples*/
        Set<Example> Y ;    
        do{
           
            Y = new HashSet<>();
            for (int i = 0; i < examples.size(); i++) {
                Example x = examples.get(i);
                //System.out.println(delx(x.cls)*Vector.dot(x.weightVector, this.weightVector));
                    if(delx(x.cls)*Vector.dot(x.weightVector, this.weightVector) >= 0){
                        Y.add(x);
                    }
            }
            Vector summ = new Vector(weightVector.size());  //empty vector, 0, 0, 0 
        
            for(Example x : Y){
               summ.add(Vector.multiply(x.weightVector, delx(x.cls)));   
            }
             
            //System.out.println();
            this.weightVector.sub(Vector.multiply(summ, learnRate));
            //adjust learnrate
            
            t  =  t + 1;
             //learnRate = 10/(t);
            System.out.println(this.weightVector);
            
        }while(!Y.isEmpty() );
        
            System.out.println("No. of iterations:"+ t);
        //this.weightVector = weightVector;
    }   
    
    private int delx(int cls){
        if(cls==1){
            return -1; //if class is w1, wTx > 0, so delx is -1  
        }else{
            return 1;
        }
    }
    
//    public int test(Example e){
//        
//    }
    
}
