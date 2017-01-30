import org.junit.Test;
import static org.junit.Assert.*;

public class EllysSubstringSorterTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "TOPCODER";
		int L = 4;
		assertEquals("COPTODER", new EllysSubstringSorter().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "ESPRIT";
		int L = 3;
		assertEquals("EPRSIT", new EllysSubstringSorter().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "AAAAAAAAA";
		int L = 2;
		assertEquals("AAAAAAAAA", new EllysSubstringSorter().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "ABRACADABRA";
		int L = 5;
		assertEquals("AAABCRDABRA", new EllysSubstringSorter().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "BAZINGA";
		int L = 6;
		assertEquals("ABGINZA", new EllysSubstringSorter().getMin(S, L));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD";
		int L = 21;
		assertEquals("AAAAAABDDDEEIIIJOOSUWWWWDBPOAWDUISAWDOOPAWD", new EllysSubstringSorter().getMin(S, L));
	}
}
