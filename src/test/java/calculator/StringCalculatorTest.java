package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	static StringCalculator calculator;

	@BeforeAll
	static void beforeAll() {
		calculator = new StringCalculator();
	}

	@Test
	void add_빈문자열_또는_널() {
		assertEquals(0, calculator.add(""));
		assertEquals(0, calculator.add(null));
	}

	@Test
	void add_숫자하나() {
		assertEquals(4, calculator.add("4"));
	}

	@Test
	void add_숫자여러개_콤마() {
		assertEquals(9, calculator.add("4,5"));
		assertEquals(15, calculator.add("4,5,6"));
		assertEquals(10, calculator.add("1,2,3,4"));
	}

	@Test
	void add_숫자여러개_콜론() {
		assertEquals(9, calculator.add("4:5"));
		assertEquals(15, calculator.add("4:5:6"));
		assertEquals(10, calculator.add("1:2:3:4"));
	}

	@Test
	void add_숫자여러개_콜론_콤마_혼합() {
		assertEquals(15, calculator.add("4,5:6"));
		assertEquals(10, calculator.add("1:2,3:4"));
	}
	
	@Test
	void add_숫자_음수_예외() {
		Exception exception = assertThrows(RuntimeException.class, () -> calculator.add("-5"));
		assertEquals("음수는 사용할 수 없습니다.", exception.getMessage());
	}
	
	@Test
	void add_숫자_커스텀구분자() {
		assertEquals(13, calculator.add("//;\n3;10"));
		assertEquals(13, calculator.add("//@\n3@10"));
	}

}
