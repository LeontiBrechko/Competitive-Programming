import org.junit.Test;
import static org.junit.Assert.*;

public class MagicSubsetTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] values = new int[] {1,10,4,-6,3};
		assertEquals(17, new MagicSubset().findBest(values));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] values = new int[] {3,-5,1,-6};
		assertEquals(8, new MagicSubset().findBest(values));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] values = new int[] {0,0,0,0,0,0,0,0,0};
		assertEquals(0, new MagicSubset().findBest(values));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] values = new int[] {-100};
		assertEquals(100, new MagicSubset().findBest(values));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] values = new int[] {100};
		assertEquals(0, new MagicSubset().findBest(values));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] values = new int[] {-3,1,-4,1,5,-9,2,6,-5,3,5};
		assertEquals(23, new MagicSubset().findBest(values));
	}
}
