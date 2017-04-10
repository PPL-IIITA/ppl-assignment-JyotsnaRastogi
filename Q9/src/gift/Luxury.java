//luxury gift class
package gift;


public class Luxury extends Gift {
    public int luxuryrate,diff;
    public Luxury(String name,int price,int value,int luxuryrate,int diff) {
        super(name,price,value);
        this.luxuryrate=luxuryrate;
        this.diff=diff;
    }
}

