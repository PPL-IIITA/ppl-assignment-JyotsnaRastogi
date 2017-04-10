/*class containing functions to read from files*/
package readfile;

import boy.Boy;
import boy.Miser;
import boy.Generous;
import boy.Geek;
import girl.Girl;
import girl.Choosy;
import girl.Desperate;
import girl.Normal;
import gift.Gift;
import gift.Essential;
import gift.Luxury;
import gift.Utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class file {
    public static Boy addboy(String[] s)      //method to extract field data and return Boy object
        { 
            String name = s[0];
            int attract = Integer.parseInt(s[1]);
            int budget = Integer.parseInt(s[2]);
            int itg = Integer.parseInt(s[3]);
            
            String type=s[4];
            int attneed= Integer.parseInt(s[5]);
            if(type.equals("miser"))
                 return new Miser(name,attract,budget,itg,attneed);
            else if(type.equals("generous"))
                return new Generous(name,attract,budget,itg,attneed);
            else 
                return new Geek(name, attract,budget,itg,attneed);
        
        }
    
     public static List<Boy> readb(String fileName)                //method to read boy file
        {
            List<Boy> boy = new ArrayList<>();
             Path path = Paths.get(fileName);
        
            
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII))
            {
              
                String line = br.readLine();
               
                while (line != null) {
                    
                    String[] attributes = line.split(","); 
                    Boy Boy = addboy(attributes); 
          
                    boy.add(Boy); 
                    
                    line = br.readLine(); } 
            } 
            catch (IOException ioe) {
            
                ioe.printStackTrace();
            } 
        return boy;
        }
      
       public static Girl addgirl(String[] s)           //method to extract field data and return Girl object
        { 
            String name = s[0];
            int attract = Integer.parseInt(s[1]);
            int budget = Integer.parseInt(s[2]);
            int itg = Integer.parseInt(s[3]);
            String type=s[4];
            int attneed= Integer.parseInt(s[5]);
            int itgneed=Integer.parseInt(s[6]);
            if(type.equals("choosy"))
                return new Choosy(name, attract,budget,itg,type,attneed,itgneed);
            else if(type.equals("normal")) 
                return new Normal(name, attract,budget,itg,type,attneed,itgneed);
            else
                return new Desperate(name, attract,budget,itg,type,attneed,itgneed);
        
        }
      
      public static List<Girl> readg(String fileName)                   //method to read girl file
        {
            List<Girl> girl = new ArrayList<>();
             Path path = Paths.get(fileName);
        
            
            
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII))
            {
                
                String line = br.readLine();
                
                while (line != null) {
                  
                    String[] attributes = line.split(","); 
                    Girl Girl = addgirl(attributes); 
                    
                    girl.add(Girl); 
                  
                    line = br.readLine(); } 
            } 
            catch (IOException ioe) {
            
                ioe.printStackTrace();
            } 
        return girl;
        }
      
       public static Gift addgift(String[] s)                        //method to extract field data and return Gift object
        { 
            String name = s[0];
             int price = Integer.parseInt(s[1]);
            int value = Integer.parseInt(s[2]);
            String type=s[3];
            if(type.equals("luxury")) {
                int luxury = Integer.parseInt(s[4]);
                int diff=Integer.parseInt(s[5]);
                 return new Luxury(name,price,value,luxury,diff);
            }
             if(type.equals("utility")) {
                  int utval= Integer.parseInt(s[4]);
                  int utclass=Integer.parseInt(s[5]);
                   return new Utility(name,price,value,utval,utclass);
            }
           return new Essential(name,price,value);
        
        }
    
     public static List<Gift> readgift(String fileName)                  // to read gift file
        {
            List<Gift> gift = new ArrayList<>();
             Path path = Paths.get(fileName);
        
            
            
            try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII))
            {
               
                String line = br.readLine();
              
                while (line != null) {
                    
                    String[] attributes = line.split(","); 
                    Gift ggift = addgift(attributes); 
                    
                    gift.add(ggift); 
                  
                    line = br.readLine(); } 
            } 
            catch (IOException ioe) {
            
                ioe.printStackTrace();
            } 
        return gift;
        }
  
      
}
