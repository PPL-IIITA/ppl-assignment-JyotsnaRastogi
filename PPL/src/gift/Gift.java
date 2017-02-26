/* class for gift and its details is given here*/
package gift;


public class Gift {
   public int price,luxuryrate;
   public int value,diff,utval,utclass;
   public String type,name;
   public Gift(String name,int price,int value,String type,int luxuryrate,int diff) {
       this.name=name;
       this.price=price;
        this.type=type;
        this.value=value;
        if(this.type.equals("utility")){
             this.utclass=luxuryrate;
             this.utval=diff;
        }
        else {
        this.luxuryrate=luxuryrate;
        this.diff=diff;
        }
        
       
    } 
    public Gift(String name,int price,int value,String type) {
        this.name=name;
        this.price=price;
        this.value=value;
         this.type=type;
    } 
  
   
    
}
