
package Exc;

import girl.Girl;

/**
 *
 * class defining Boyfriend not found exception
 */
public class BoyNotFound extends Exception {
    Girl g;
    public BoyNotFound(Girl g) {
        this.g=g;
    }
   public  Girl sendgirl() {
        return g;
    }
}
