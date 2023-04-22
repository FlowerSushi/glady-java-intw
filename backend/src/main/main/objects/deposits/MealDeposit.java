package objects.deposits;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class MealDeposit extends Deposit {
    public MealDeposit(Float amount) throws DepositException {
        // Gifts expire on the last day of february of next year
        super(amount, LocalDateTime.now().plusYears(1).withMonth(2).with(TemporalAdjusters.lastDayOfMonth()));
    }
}
