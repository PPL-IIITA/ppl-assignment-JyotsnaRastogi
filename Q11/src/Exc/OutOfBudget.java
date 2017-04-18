
package Exc;

import gift.Gift;

/**
 *
 * Gift out of budget exception
 */
public class OutOfBudget extends Exception {
      Gift g;
    public OutOfBudget(Gift g) {
        this.g=g;
    }
   public Gift sendgift() {
        return g;
    }
}
