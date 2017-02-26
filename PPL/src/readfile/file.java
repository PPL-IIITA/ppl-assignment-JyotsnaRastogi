/*class containing functions to read from files*/
package readfile;

import boy.Boy;
import girl.Girl;
import gift.Gift;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class file {
    
    public static Boy addboy(String[] s)
        { 
            String name = s[0];
            int attract = Integer.parseInt(s[1]);
            int budget = Integer.parseInt(s[2]);
            int itg = Integer.parseInt(s[3]);
            
            String type=s[4];
            int attneed= Integer.parseInt(s[5]);
           return new Boy(name, attract,budget,itg,type,attneed);
        
        }
    
     public static List<Boy> readb(String fileName)
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
      
       public static Girl addgirl(String[] s)
        { 
            String name = s[0];
            int attract = Integer.parseInt(s[1]);
            int budget = Integer.parseInt(s[2]);
            int itg = Integer.parseInt(s[3]);
            String type=s[4];
            int attneed= Integer.parseInt(s[5]);
            int itgneed=Integer.parseInt(s[6]);
            return new Girl(name, attract,budget,itg,type,attneed,itgneed);
        
        }
      
      public static List<Girl> readg(String fileName)
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
      
       public static Gift addgift(String[] s)
        { 
            String name = s[0];
             int price = Integer.parseInt(s[1]);
            int value = Integer.parseInt(s[2]);
            String type=s[3];
            if(type.equals("luxury")) {
                int luxury = Integer.parseInt(s[4]);
                int diff=Integer.parseInt(s[5]);
                 return new Gift(name,price,value,type,luxury,diff);
            }
             if(type.equals("utility")) {
                  int utval= Integer.parseInt(s[4]);
                  int utclass=Integer.parseInt(s[5]);
                   return new Gift(name,price,value,type,utval,utclass);
            }
           return new Gift(name,price,value,type);
        
        }
    
     public static List<Gift> readgift(String fileName)
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
    
