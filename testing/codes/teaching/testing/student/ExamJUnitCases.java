package codes.teaching.testing.student;

import java.io.File;
import java.time.LocalDateTime;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import question.MarketNavigator;

/* TODO: Import the classes you need for testing */

// Tests will be sorted in lexicographical order. Therefore start the names as "test1_TestName" 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//@RunWith(JUnit4.class)
public final class ExamJUnitCases extends ExamJUnit {

	//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	//	private final PrintStream originalOut = System.out;
	//	private final PrintStream originalErr = System.err;

	public static String lineSeperator = System.lineSeparator();

	@Rule
	public TestName name = new TestName();

	@Test
	public void test1() {
		String inputForReport = "Result for first coordinates file";
		String expectedAnswer = "27";

		ExamJUnit.testInitialization(1, name.getMethodName(), inputForReport, expectedAnswer);
		try {
			String answerStudent = "";
			String path = ExamJUnitCases.class.getProtectionDomain().getCodeSource().getLocation().getPath()   + File.separator + ".." + File.separator + "coordinates.txt";
			int result = MarketNavigator.pathFinder(path);
			answerStudent = Integer.toString(result);
			ExamJUnit.testCheck(answerStudent);
			
		} catch (Exception e) {
			testFailedExecution(e);
		}
	}
}
