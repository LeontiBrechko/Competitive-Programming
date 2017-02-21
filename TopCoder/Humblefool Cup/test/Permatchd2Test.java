import org.junit.Test;
import static org.junit.Assert.*;

public class Permatchd2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] graph = new String[] {"NYN",
 "YNN",
 "NNN"};
		assertEquals(1, new Permatchd2().fix(graph));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] graph = new String[] {"NYY",
 "YNN",
 "YNN"};
		assertEquals(0, new Permatchd2().fix(graph));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] graph = new String[] {"NYY",
 "YNY",
 "YYN"};
		assertEquals(-1, new Permatchd2().fix(graph));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] graph = new String[] {"NYYY",
 "YNYY",
 "YYNN",
 "YYNN"};
		assertEquals(1, new Permatchd2().fix(graph));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] graph = new String[] {"NYNNNN",
 "YNNNNN",
 "NNNYNN",
 "NNYNNN",
 "NNNNNY",
 "NNNNYN"};
		assertEquals(3, new Permatchd2().fix(graph));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] graph = new String[] {"N"};
		assertEquals(0, new Permatchd2().fix(graph));
	}
}
