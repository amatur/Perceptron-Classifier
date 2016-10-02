import java.util.ArrayList;

public class Kesler {

    ArrayList<Example> examples;
    ArrayList<Example> vectors;
    double ro;
    double numClasses;

    public Kesler(double ro, ArrayList<Example> trainExamples, int numClasses) {
        this.examples = new ArrayList<>();
        this.vectors = new ArrayList<>();
        this.ro = ro;
        this.numClasses = numClasses;
        int numFeaturesPlus1 = trainExamples.get(0).featureVector.size();
        System.out.println(numClasses);
        System.out.println(trainExamples);
        for (int i = 0; i < numClasses; i++) {
            for (int j = 0; j < numClasses; j++) {
                if (i != j) {
                    for (Example trainExample : trainExamples) {
                        Vector plusX = trainExample.featureVector;
                        Vector minusX = Vector.multiply(plusX, -1);
                        //System.out.println(plusX);
                        //System.out.println(minusX);

                        //big vector construction
                        Vector compo = new Vector(0);
                        if(trainExample.cls!=i+1) continue;
                        for (int k = 0; k < numClasses; k++) {
                            if (k == i) {
                                compo.concat(plusX);
                            } else if (k == j) {
                                compo.concat(minusX);
                            } else {
                                compo.concat(new Vector(numFeaturesPlus1));
                            }
                        }
                        this.examples.add(new Example(compo, 1));

                    }

                }
            }
        }

        Vector compoWeightVector = new Vector(0);
        for (int i = 0; i < numClasses * numFeaturesPlus1; i++) {
            compoWeightVector.v.add(1.0);
        }
        System.out.println(this.examples);
        ///*
        PerceptronClassifier pc = new PerceptronClassifier(ro, examples, compoWeightVector);
        //populate m weight vectors
        for (int i = 0; i < numClasses*numFeaturesPlus1; i=i+numFeaturesPlus1) {
            Vector vector = new Vector(0);
            for (int j = i; j < i + numFeaturesPlus1; j++) {
                vector.v.add(pc.weightVector.v.get(j));
            }
            vectors.add(new Example(vector, i/numFeaturesPlus1 + 1));
        }

        System.out.println(vectors);

        //pc.weightVector;
        //*/
    }

    
    
    /**
     * *
     *
     * @param testList List of examples to test.
     * @return Accuracy of the test set.
     */
    public double test(ArrayList<Example> examples) {
        //start testing
        int correct = 0;
        int wrong = 0;

        for (Example testEx : examples) {
            //System.out.println(testEx);
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
        for (int i = 0; i < numClasses; i++) {
            int cnt = 0;
            for (int j = 0; j < numClasses; j++) {
              if(i!=j){
                  try {
                      if (Vector.dot(vectors.get(i).featureVector, testExample.featureVector) > Vector.dot(vectors.get(j).featureVector, testExample.featureVector)) {
                      cnt++;
                  }
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  
              }
            }
            if(cnt==numClasses-1) return vectors.get(i).cls;
        }
        return 1;      
        
    }
    
    
}
