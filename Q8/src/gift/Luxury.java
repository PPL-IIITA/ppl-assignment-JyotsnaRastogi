//luxury gift class
package gift;


public class Luxury extends Gift {
    public int luxuryrate,diff;
    public Luxury(String name,int price,int value,int luxuryrate,int diff,String type) {
        super(name,price,value,type);
        this.luxuryrate=luxuryrate;
        this.diff=diff;
    }
}

