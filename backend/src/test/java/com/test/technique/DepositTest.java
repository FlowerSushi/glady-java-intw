package com.test.technique;

import com.test.technique.objects.deposits.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static com.test.technique.objects.deposits.DepositType.GIFT;
import static com.test.technique.objects.deposits.DepositType.MEAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DepositTest {

    @Test
    void deposit_factory_should_return_meal() throws DepositException {
        int year = LocalDateTime.now().getYear() + 1;
        LocalDateTime expectedDate = LocalDateTime.of(year, 2, 1, 23, 59, 59, 999999999).with(TemporalAdjusters.lastDayOfMonth());

        Deposit deposit = DepositFactory.createDeposit(MEAL, 25f);

        assertThat(MealDeposit.class).isEqualTo(deposit.getClass());
        assertThat(deposit.getExpirationDate()).isEqualTo(expectedDate);
        assertThat(deposit.getAmount()).isEqualTo(25f);
    }

    @Test
    void deposit_factory_should_return_gift() throws DepositException {
        LocalDateTime expectedDate = LocalDateTime.now().plusDays(365).withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        Deposit deposit = DepositFactory.createDeposit(GIFT, 25f);

        assertThat(GiftDeposit.class).isEqualTo(deposit.getClass());
        assertThat(deposit.getExpirationDate()).isEqualTo(expectedDate);
        assertThat(deposit.getAmount()).isEqualTo(25f);
    }

    @Test
    void new_meal_deposit_should_throw_deposit_exception() {
        assertThatExceptionOfType(DepositException.class).isThrownBy(() -> DepositFactory.createDeposit(MEAL,-25f));
    }
}
