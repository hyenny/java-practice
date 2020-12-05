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
	void add_���ڿ�_�Ǵ�_��() {
		assertEquals(0, calculator.add(""));
		assertEquals(0, calculator.add(null));
	}

	@Test
	void add_�����ϳ�() {
		assertEquals(4, calculator.add("4"));
	}

	@Test
	void add_���ڿ�����_�޸�() {
		assertEquals(9, calculator.add("4,5"));
		assertEquals(15, calculator.add("4,5,6"));
		assertEquals(10, calculator.add("1,2,3,4"));
	}

	@Test
	void add_���ڿ�����_�ݷ�() {
		assertEquals(9, calculator.add("4:5"));
		assertEquals(15, calculator.add("4:5:6"));
		assertEquals(10, calculator.add("1:2:3:4"));
	}

	@Test
	void add_���ڿ�����_�ݷ�_�޸�_ȥ��() {
		assertEquals(15, calculator.add("4,5:6"));
		assertEquals(10, calculator.add("1:2,3:4"));
	}
	
	@Test
	void add_����_����_����() {
		Exception exception = assertThrows(RuntimeException.class, () -> calculator.add("-5"));
		assertEquals("������ ����� �� �����ϴ�.", exception.getMessage());
	}
	
	@Test
	void add_����_Ŀ���ұ�����() {
		assertEquals(13, calculator.add("//;\n3;10"));
		assertEquals(13, calculator.add("//@\n3@10"));
	}

}
