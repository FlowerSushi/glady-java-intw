package objects.deposits;

import java.time.LocalDateTime;

public class GiftDeposit extends Deposit {
    public GiftDeposit(Float amount) throws DepositException {
        // Gifts expire after 365 days
        super(amount, LocalDateTime.now().plusDays(365));
    }
}
