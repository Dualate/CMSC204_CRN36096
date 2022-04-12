import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Student_JUnit_Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		File file = new File("C:\\Users\\User\\eclipse\\Assignment_5\\src\\morsetest.txt");
		File file1 = new File("C:\\Users\\User\\eclipse\\Assignment_5\\src\\morsetest1.txt");
		File file2 = new File("C:\\Users\\User\\eclipse\\Assignment_5\\src\\morsetest2.txt");

		try {
			assertEquals(MorseCodeConverter.convertToEnglish(file), "if i speak with human eloquence and angelic ecstasy");
			assertEquals(MorseCodeConverter.convertToEnglish(file1), "but i dont love i am nothing but the creaking of a rusty gate");
			assertEquals(MorseCodeConverter.convertToEnglish(file2), "if i speak gods word with power revealing all of his mysteries making everything as plain as day");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		assertEquals("sphinx of black quartz judge my vow", MorseCodeConverter.convertToEnglish("... .--. .... .. -. -..- / --- ..-. / -... .-.. .- -.-. -.- / --.- ..- .- .-. - --.. /"
				+ " .--- ..- -.. --. . / -- -.-- / ...- --- .--"));
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

}
