
import java.util.ArrayList;
import java.util.Arrays;

public class Vector {
    ArrayList<Double> v;
    
    public int size(){
        return v.size();
    }
    
    public Vector(ArrayList<Double> v) {
        this.v = v;
    }
    
    public Vector(Double[] array) {
        this.v = new ArrayList<Double>(Arrays.asList(array));
    }
    
    public Vector(Vector v2) {
        this.v = new ArrayList<Double>(v2.v) ;
    }

    public Vector(int size) {
        v = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            v.add(0.0);
        }
    }

    public void add(Vector v1) {
        for (int i = 0; i < this.v.size(); i++) {
            v.set(i, v1.v.get(i) + v.get(i));
        }
    }
      public void sub(Vector v1) {
        for (int i = 0; i < this.v.size(); i++) {
            v.set(i, v.get(i) - v1.v.get(i));
        }
    }

    public void multiply(double scalar) {
        for (int i = 0; i < this.v.size(); i++) {
            v.set(i,  v.get(i) * scalar);
        }
    }
    
    public static Vector add(Vector v1, Vector v2) {
        int n = v1.v.size();
        ArrayList<Double> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add( v1.v.get(i) + v2.v.get(i));
        }
        return new Vector(res);
    }

    public static Vector sub(Vector v1, Vector v2) {
        int n = v1.v.size();
        ArrayList<Double> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add( v1.v.get(i) - v2.v.get(i));
        }
        return new Vector(res);
    }

    public static Vector multiply(Vector v1, double scalar) {
        int n = v1.v.size();
        ArrayList<Double> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(  v1.v.get(i) * scalar);
        }
        return new Vector(res);
    }
    
    
    public static double dot(Vector w, Vector x){
        int N = w.v.size();
        double dot = 0;
        for (int i = 0; i < N; i++) {
            dot += w.v.get(i) * x.v.get(i);
        }
        return dot;
    }
    
//    
//    
//
//    public static ArrayList<Double> add(ArrayList<Double> v1, ArrayList<Double> v2) {
//        int n = v1.size();
//        ArrayList<Double> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            res.add(i, v1.get(i) + v2.get(i));
//        }
//        return res;
//    }
//
//    public static ArrayList<Double> sub(ArrayList<Double> v1, ArrayList<Double> v2) {
//        int n = v1.size();
//        ArrayList<Double> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            res.add(i, v1.get(i) - v2.get(i));
//        }
//        return res;
//    }
//
//    public static ArrayList<Double> multiply(ArrayList<Double> v1, double scalar) {
//        int n = v1.size();
//        ArrayList<Double> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            res.add(i, v1.get(i) * scalar);
//        }
//        return res;
//    }

    @Override
    public String toString() {
        return "{" + v + '}';
    }
    
}
