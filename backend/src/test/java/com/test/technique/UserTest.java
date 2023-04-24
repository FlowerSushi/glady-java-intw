package com.test.technique;

import com.test.technique.objects.people.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void user_get_balance_should_ignore_expired() {
        User user = new User();
        // not sure how to declare expired deposits without destroying the implemented logic
        // I don't want Deposit to not be abstract and don't want to accept a date arguments in child's classes constructors
    }
}
