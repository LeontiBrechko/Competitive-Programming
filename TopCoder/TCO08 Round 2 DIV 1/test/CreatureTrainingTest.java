import org.junit.Test;
import static org.junit.Assert.*;

public class CreatureTrainingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] count = new int[] {1, 2, 3, 4, 5};
		int[] power = new int[] {1, 2, 3, 4, 5};
		int D = 10;
		assertEquals(65L, new CreatureTraining().maximumPower(count, power, D));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] count = new int[] {1, 2, 3, 4, 5};
		int[] power = new int[] {1, 4, 9, 16, 25};
		int D = 10;
		assertEquals(309L, new CreatureTraining().maximumPower(count, power, D));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] count = new int[] {1000, 0, 0, 0, 0};
		int[] power = new int[] {0, 100, 10, 1000, 0};
		int D = 8;
		assertEquals(2200L, new CreatureTraining().maximumPower(count, power, D));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] count = new int[] {1, 2, 3, 4, 5};
		int[] power = new int[] {5, 4, 3, 2, 1};
		int D = 50;
		assertEquals(35L, new CreatureTraining().maximumPower(count, power, D));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] count = new int[] {0, 5, 0, 0, 5, 0};
		int[] power = new int[] {13, 20, 21, 30, 32, 36};
		int D = 12;
		assertEquals(318L, new CreatureTraining().maximumPower(count, power, D));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] count = new int[] {0, 2, 1, 0, 0, 1, 2};
		int[] power = new int[] {25, 292, 328, 391, 618, 771, 952};
		int D = 11;
		assertEquals(5088L, new CreatureTraining().maximumPower(count, power, D));
	}
}
