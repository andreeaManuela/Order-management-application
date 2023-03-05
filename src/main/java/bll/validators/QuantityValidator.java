package bll.validators;
import Model.Order;

/**
 * aceasta clasa valideaza cantitatea astfel incat sa nu fie introdusa gresit
 */

public class QuantityValidator implements Validator<Order> {
    private static  final int MIN_Q=0;
    private static final int MAX_Q=1000;

    public void validate(Order or)
    {
        if(or.getQuantity() < MIN_Q || or.getQuantity()> MAX_Q)
        {
            throw new IllegalArgumentException("The quantity is not respected!");
        }
    }
}
