package bll.validators;
import Model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *           Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * Aceasta clasa valideaza varsta astfel incat clientul sa aiba varsta cuprinsa intre un anumit interval
 */

public class ClientAgeValidator implements Validator<Client >{
    private static final int MIN_AGE=10;
    private static final int MAX_AGE=75;

    @Override
    public void validate(Client t) {
        if(t.getAge() < MIN_AGE || t.getAge()> MAX_AGE)
        {
            throw new IllegalArgumentException("The Client age limit is not respected!");
        }

    }
}
