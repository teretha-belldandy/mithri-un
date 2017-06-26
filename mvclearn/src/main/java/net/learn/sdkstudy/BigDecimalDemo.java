package net.learn.sdkstudy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal amount = new BigDecimal("0.1").movePointRight(2);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (amount.compareTo(new BigDecimal(0)) >= 0) {
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        } else {
            decimalFormat.setRoundingMode(RoundingMode.CEILING);
        }
        String result = decimalFormat.format(amount);
        result = String.format("%s%%-%s%%", result, result);

		System.out.println(result);
	}

}
