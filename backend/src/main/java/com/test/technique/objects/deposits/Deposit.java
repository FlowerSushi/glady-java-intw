package com.test.technique.objects.deposits;

import java.time.LocalDateTime;

public abstract class Deposit {
    Float amount;
    LocalDateTime expirationDate;

    protected Deposit(Float amount, LocalDateTime expirationDate) {
        this.amount = amount;
        // Deposits all expire at the end of a day
        this.expirationDate = expirationDate.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "amount=" + amount +
                ", expirationDate=" + expirationDate +
                '}';
    }
}