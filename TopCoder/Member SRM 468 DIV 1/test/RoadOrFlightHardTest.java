import org.junit.Test;
import static org.junit.Assert.*;

public class RoadOrFlightHardTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 3;
		int roadFirst = 14;
		int roadProd = 1;
		int roadAdd = 2;
		int roadMod = 10;
		int flightFirst = 18;
		int flightProd = 1;
		int flightAdd = 10;
		int flightMod = 17;
		int K = 1;
		assertEquals(14L, new RoadOrFlightHard().minTime(N, roadFirst, roadProd, roadAdd, roadMod, flightFirst, flightProd, flightAdd, flightMod, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 3;
		int roadFirst = 4;
		int roadProd = 1;
		int roadAdd = 2;
		int roadMod = 10;
		int flightFirst = 1;
		int flightProd = 1;
		int flightAdd = 10;
		int flightMod = 17;
		int K = 2;
		assertEquals(11L, new RoadOrFlightHard().minTime(N, roadFirst, roadProd, roadAdd, roadMod, flightFirst, flightProd, flightAdd, flightMod, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 3;
		int roadFirst = 4;
		int roadProd = 1;
		int roadAdd = 2;
		int roadMod = 10;
		int flightFirst = 1;
		int flightProd = 1;
		int flightAdd = 6;
		int flightMod = 9;
		int K = 1;
		assertEquals(12L, new RoadOrFlightHard().minTime(N, roadFirst, roadProd, roadAdd, roadMod, flightFirst, flightProd, flightAdd, flightMod, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 5;
		int roadFirst = 85739;
		int roadProd = 94847;
		int roadAdd = 93893;
		int roadMod = 98392;
		int flightFirst = 92840;
		int flightProd = 93802;
		int flightAdd = 93830;
		int flightMod = 92790;
		int K = 3;
		assertEquals(122365L, new RoadOrFlightHard().minTime(N, roadFirst, roadProd, roadAdd, roadMod, flightFirst, flightProd, flightAdd, flightMod, K));
	}
}
