/*class for testing utility */
package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class test2 {
    public void tester() throws IOException {   /*function for random value generation and writing to file*/ 
        Random random = new Random();
        int i,t;
         try {
              BufferedWriter w=new BufferedWriter(new FileWriter("src\\boy.csv",true));
        for(i=0;i<20;i++) {
            
           String m;
           t=random.nextInt(3);
           
           int att=random.nextInt(100);
           int b=random.nextInt(100);
           int it=random.nextInt(100);
           int itn=random.nextInt(100);
            if(t==0) {
                     m=new String("miser");
                  }
                  else if(t==1) 
                     m= new String("generous");
                  else
                     m= new String("geek");
            w.write("b"+i+","+att+","+b+","+it+","+m+","+itn);
            w.newLine();
            
      }
        w.close();
      
   
  }
         catch (IOException e) {
            
                e.printStackTrace();
            }
    
    
      try {
              BufferedWriter w=new BufferedWriter(new FileWriter("src\\girl.csv",true));
        for(i=0;i<12;i++) {
            
           String m;
           t=random.nextInt(3);
           
           int att=random.nextInt(100);
           int b=random.nextInt(100);
           int it=random.nextInt(100);
           int itn=random.nextInt(100);
           int itg=random.nextInt(100);
            if(t==0) {
                     m=new String("choosy");
                  }
                  else if(t==1) 
                     m= new String("normal");
                  else
                     m= new String("desperate");
            w.write("g"+i+","+att+","+b+","+it+","+m+","+itn+","+itg);
            w.newLine();
            
      }
        w.close();
      
   
  }
         catch (IOException e) {
            
                e.printStackTrace();
            }
     
    
         try {
              BufferedWriter w=new BufferedWriter(new FileWriter("src\\gift.csv",true));
        for(i=0;i<10;i++) {
            
           String m;
           t=random.nextInt(3);
           
           int price=random.nextInt(100);
           int value=random.nextInt(100);
           int att,it;
           
             if(t==0) {
                     m="essential";
                      att=0;
                       it=0;
                  }
                  else if(t==1) {
                     m="luxury";
                     att=random.nextInt(5);
                   it=random.nextInt(100);
                     
                  }
                  else {
                     m="utility";
                     att =random.nextInt(10);
                   it=random.nextInt(100);
                  }
            w.write("gif"+i+","+price+","+value+","+m+","+att+","+it);
            w.newLine();
            
      }
        w.close();
      
   
  }
         catch (IOException e) {
            
                e.printStackTrace();
            }
    } 
    
    
    
    
  
}
