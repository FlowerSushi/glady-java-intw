package com.test.technique.objects.deposits;

import java.time.LocalDateTime;

public class GiftDeposit extends Deposit {
    public GiftDeposit(Float amount) {
        // Gifts expire after 365 days
        super(amount, LocalDateTime.now().plusDays(365));
    }
}
