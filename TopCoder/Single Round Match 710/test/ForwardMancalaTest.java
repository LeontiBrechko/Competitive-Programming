import org.junit.Test;
import static org.junit.Assert.*;

public class ForwardMancalaTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] start = new int[] {6,1,0,1};
		assertArrayEquals(new int[] {1, 2, 3, 1, 2, 3 }, new ForwardMancala().findMoves(start));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] start = new int[] {0,10,0,0,0};
		assertArrayEquals(new int[] { }, new ForwardMancala().findMoves(start));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] start = new int[] {0,1,0,1,0,1};
		assertArrayEquals(new int[] {3, 4, 1, 2, 3, 4 }, new ForwardMancala().findMoves(start));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] start = new int[] {5,0,0,1,3,0,2,0};
		assertArrayEquals(new int[] {3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7 }, new ForwardMancala().findMoves(start));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] start = new int[] {10,10,10,10,10,10,10,10,10,10};
		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, new ForwardMancala().findMoves(start));
	}
}
