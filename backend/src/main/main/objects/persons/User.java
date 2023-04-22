package objects.persons;

import objects.deposits.Deposit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Deposit> deposits;

    public User() {
        this.deposits = new ArrayList<>();
    }

    public Float getBalance() {
        return deposits.stream()
                .filter(d -> LocalDateTime.now().isBefore(d.getExpirationDate()))
                .map(Deposit::getAmount)
                .reduce(0f, Float::sum);
    }

    public void addDeposit(Deposit deposit) {
        deposits.add(deposit);
    }
}
