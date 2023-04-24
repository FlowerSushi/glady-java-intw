package com.test.technique.objects.people;

import com.test.technique.objects.deposits.DepositException;
import com.test.technique.objects.deposits.DepositFactory;
import com.test.technique.objects.deposits.DepositType;

public class Company {
    private Float balance;

    public Company(Float balance) {
        this.balance = balance;
    }

    public void giveDeposit(User user, DepositType type, Float amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            try {
                user.addDeposit(DepositFactory.createDeposit(type, amount));
                balance -= amount;
            } catch (DepositException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Float getBalance() {
        return balance;
    }
}
