import org.junit.Test;
import static org.junit.Assert.*;

public class CrossTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {".##",
 "###",
 "##."};
		assertEquals("Exist", new Cross().exist(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {".##",
 "###",
 "#.."};
		assertEquals("Does not exist", new Cross().exist(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"######",
 "######",
 "######",
 "######",
 "######",
 "######",
 "######"};
		assertEquals("Exist", new Cross().exist(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {".#.#",
 "#.#.",
 ".#.#",
 "#.#."};
		assertEquals("Does not exist", new Cross().exist(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {".#.#",
 "###.",
 ".###",
 "#.#."};
		assertEquals("Exist", new Cross().exist(board));
	}
}
