package objects.deposits;

public class DepositFactory {
    public static Deposit createDeposit(DepositType type, Float amount) {
        Deposit d = null;
        try {
            switch (type) {
                case GIFT -> d = new GiftDeposit(amount);
                case MEAL -> d = new MealDeposit(amount);
            }
        } catch (DepositException exception) {
            System.out.println(exception.getMessage());
        }
        return d;
    }
}
