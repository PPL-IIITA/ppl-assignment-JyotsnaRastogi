/*
class for choosy girl
 */
package girl;

import static java.lang.Math.exp;
import static java.lang.Math.log;

public class Choosy extends Girl {
     public Choosy(String name,int attract,int mbudget,int itg,String type,int a,int b) {   //constructor
         super(name,attract,mbudget,itg,type,a,b);
     }
      public float girlhappy(float s) {     //function for finding girl's happiness
        float happiness=0; 
        happiness=(float) log(s/mbudget);  
        return happiness;
    }
}
