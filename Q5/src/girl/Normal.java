//normal girl class
package girl;

import static java.lang.Math.exp;
import static java.lang.Math.log;

/**
 *
 * @author JAYANT RASTOGI
 */
public class Normal extends Girl {
  
     public Normal(String name,int attract,int mbudget,int itg,String type,int a,int b) {
         super(name,attract,mbudget,itg,type,a,b);
     }
     public float girlhappy(float s) {  //to find girls happiness
        float happiness=0; 
   
       happiness=s/mbudget;
       return happiness;    
        
    }
    
}


