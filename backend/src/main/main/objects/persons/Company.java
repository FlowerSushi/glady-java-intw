package objects.persons;

import objects.deposits.Deposit;
import objects.deposits.DepositFactory;
import objects.deposits.DepositType;

import java.util.Objects;

public class Company {
    private Float balance;

    public Company(Float balance) {
        this.balance = balance;
    }

    public void giveDeposit(User user, DepositType type, Float amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            Deposit d = DepositFactory.createDeposit(type, amount);
            if (Objects.nonNull(d)) {
                user.addDeposit(d);
            }
        }
    }

    public Float getBalance() {
        return balance;
    }
}
