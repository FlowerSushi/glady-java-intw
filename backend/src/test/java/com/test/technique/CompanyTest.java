package com.test.technique;

import com.test.technique.objects.deposits.MealDeposit;
import com.test.technique.objects.people.Company;
import com.test.technique.objects.people.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.test.technique.objects.deposits.DepositType.MEAL;
import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

    @Test
    void deposit_should_be_added_to_user() {
        Company company = new Company(5000f);
        User user = new User();

        company.giveDeposit(user, MEAL, 2500f);

        assertThat(company.getBalance()).isEqualTo(2500f);
        assertThat(user.getBalance()).isEqualTo(2500f);
        assertThat(user.getDeposits())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(List.of(new MealDeposit(2500f)));
    }

    @Test
    void deposit_should_not_be_added_to_user_insufficient_balance() {
        Company company = new Company(5000f);
        User user = new User();

        company.giveDeposit(user, MEAL, 5001f);

        assertThat(company.getBalance()).isEqualTo(5000f);
        assertThat(user.getBalance()).isEqualTo(0f);
        assertThat(user.getDeposits()).isEmpty();
    }
}
