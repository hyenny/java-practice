package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String text) {
		if (isBlank(text))
			return 0;

		return sum(toInts(split(text)));
	}

	private boolean isBlank(String text) {
		return (text == null || text.isEmpty());
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customSeparator = m.group(1);
			return m.group(2).split(customSeparator);
		}

		return text.split(",|:");
	}

	private int[] toInts(String[] values) {
		int[] numbers = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}

		return numbers;
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number < 0)
				throw new RuntimeException("음수는 사용할 수 없습니다.");

			sum += number;
		}

		return sum;
	}

}
