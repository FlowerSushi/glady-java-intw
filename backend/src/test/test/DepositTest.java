import objects.deposits.*;
import objects.persons.Company;
import objects.persons.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import static objects.deposits.DepositType.GIFT;
import static objects.deposits.DepositType.MEAL;

public class DepositTest {

    @Test
    void deposit_factory_should_return_meal() {
        int year = LocalDateTime.now().getYear() + 1;
        LocalDateTime expectedDate = LocalDateTime.of(year, 2, 1, 23, 59, 59, 999999999).with(TemporalAdjusters.lastDayOfMonth());

        Deposit deposit = DepositFactory.createDeposit(MEAL, 25f);

        Assertions.assertEquals(MealDeposit.class, deposit.getClass());
        Assertions.assertEquals(expectedDate, deposit.getExpirationDate());
        Assertions.assertEquals(25f, deposit.getAmount());
    }

    @Test
    void deposit_factory_should_return_gift() {
        LocalDateTime expectedDate = LocalDateTime.now().plusDays(365).withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        Deposit deposit = DepositFactory.createDeposit(GIFT, 25f);

        Assertions.assertEquals(GiftDeposit.class, deposit.getClass());
        Assertions.assertEquals(expectedDate, deposit.getExpirationDate());
        Assertions.assertEquals(25f, deposit.getAmount());
    }

    @Test
    void new_meal_deposit_should_throw_deposit_exception() {
        Assertions.assertThrows(DepositException.class, () -> new MealDeposit(-25f));
    }
}
