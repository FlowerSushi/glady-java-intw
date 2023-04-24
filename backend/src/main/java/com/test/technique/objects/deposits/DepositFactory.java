package com.test.technique.objects.deposits;

import java.text.DecimalFormat;

public class DepositFactory {
    private static final DecimalFormat formatter = new DecimalFormat("###.##");

    public static Deposit createDeposit(DepositType type, Float amount) throws DepositException {
        // Deposit value has to be positive
        if (amount <= 0) {
            throw new DepositException(String.format("Error creating deposit of amount %s. Value of deposit should be positive.%n", formatter.format(amount)));
        }
        return switch (type) {
            case GIFT -> new GiftDeposit(amount);
            case MEAL -> new MealDeposit(amount);
        };
    }
}
