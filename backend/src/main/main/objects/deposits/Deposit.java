package objects.deposits;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public abstract class Deposit {
    Float amount;
    LocalDateTime expirationDate;

    private static final DecimalFormat formatter = new DecimalFormat("###.##");

    protected Deposit( Float amount, LocalDateTime expirationDate) throws DepositException {
        // Deposits value have to be positive
        if (amount <= 0) {
            throw new DepositException(String.format("Error creating deposit of amount %s. Value of deposit should be positive.%n", formatter.format(amount)));
        }
        this.amount = amount;
        // Deposits all expire at the end of a day
        this.expirationDate = expirationDate.withHour(23).withMinute(59).withSecond(59);
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}