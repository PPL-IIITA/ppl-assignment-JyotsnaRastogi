/*
class for desperate girl
 */
package girl;

import static java.lang.Math.exp;
import static java.lang.Math.log;


public class Desperate extends Girl {
  
     public Desperate(String name,int attract,int mbudget,int itg,String type,int a,int b) {  //constuctor
         super(name,attract,mbudget,itg,type,a,b);
     }
     public float girlhappy(float s) {    //function for finding girl's happiness
        float happiness=0;
        happiness=(float) exp(s/mbudget);
        return happiness;
    }
}