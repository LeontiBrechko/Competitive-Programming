import org.junit.Test;
import static org.junit.Assert.*;

public class RobofactoryTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] query = new int[] {3,2,2};
		String[] answer = new String[] {"Odd", "Odd", "Even"};
		assertEquals(1, new Robofactory().reveal(query, answer));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] query = new int[] {1,3,5,10};
		String[] answer = new String[] {"Odd", "Odd", "Odd", "Even"};
		assertEquals(0, new Robofactory().reveal(query, answer));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] query = new int[] {2,3,5,10};
		String[] answer = new String[] {"Even", "Odd", "Odd", "Even"};
		assertEquals(-1, new Robofactory().reveal(query, answer));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] query = new int[] {2,4,6,10};
		String[] answer = new String[] {"Even", "Even", "Even", "Even"};
		assertEquals(-1, new Robofactory().reveal(query, answer));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] query = new int[] {107};
		String[] answer = new String[] {"Odd"};
		assertEquals(0, new Robofactory().reveal(query, answer));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] query = new int[] {1,1,1};
		String[] answer = new String[] {"Odd", "Odd", "Even"};
		assertEquals(2, new Robofactory().reveal(query, answer));
	}
}
