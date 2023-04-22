import objects.deposits.DepositException;
import objects.deposits.MealDeposit;
import objects.persons.Company;
import objects.persons.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static objects.deposits.DepositType.MEAL;

public class CompanyTest {

    @Test
    void deposit_should_be_added_to_user() throws DepositException {
        Company company = new Company(5000f);
        User user = new User();

        company.giveDeposit(user, MEAL, 2500f);

        Assertions.assertEquals(2500f, company.getBalance());
        Assertions.assertEquals(2500f, user.getBalance());
        Assertions.assertIterableEquals(List.of(new MealDeposit(2500f)), user.getDeposits());
    }

    @Test
    void deposit_should_not_be_added_to_user_insufficient_balance() {
        Company company = new Company(5000f);
        User user = new User();

        company.giveDeposit(user, MEAL, 5001f);

        Assertions.assertEquals(5000f, company.getBalance());
        Assertions.assertEquals(0f, user.getBalance());
        Assertions.assertIterableEquals(List.of(), user.getDeposits());
    }
}
