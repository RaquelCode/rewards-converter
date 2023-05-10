import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }



    @Test
    void create_with_miles_value() {
        double milesValue = 500;
        RewardValue rewardValue = new RewardValue(milesValue, true);
        assertEquals(milesValue, rewardValue.getMilesValue());
        assertEquals(milesValue * 0.0035, rewardValue.getCashValue(), 0.001);
    }




    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 300.0;
        double expectedMilesValue = 6000;

      var  rewardValue = new RewardValue(cashValue);
      double actualMilesValue =  rewardValue.getMilesValue();

        assertEquals(expectedMilesValue,actualMilesValue, rewardValue.getMilesValue(), "Conversion from cash to miles is incorrect");
    }


    @Test
    void convert_from_miles_to_cash() {
        double milesValue = 1000;
        double expectedCashValue = milesValue * 0.0035;
        RewardValue rewardValue = new RewardValue(milesValue, false);
        assertEquals(expectedCashValue, rewardValue.getCashValue(), 0.001);
    }


}
