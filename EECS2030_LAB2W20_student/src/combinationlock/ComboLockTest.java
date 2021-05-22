package combinationlock;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComboLockTest {

	int secret1 = 10;
	int secret2 = 20;
	int secret3 = 30;

	ComboLock lock = new ComboLock(secret1, secret2, secret3);

	@Test
	public void testCurrentNumber1() {
		// turn right 10 ticks
		int ticks = 10;
		lock.turnRight(ticks);
		assertTrue("Current number doesnt not equal secret1", 10 == lock.getCurrentNumber());
	}

	@Test
	public void testCurrentNumber2() {
		// turn right 10 ticks
		int ticks = 10;
		lock.turnRight(ticks);
		ticks = 30;
		lock.turnLeft(ticks);
		assertTrue("Current number doesnt not equal secret2", 20 == lock.getCurrentNumber());
	}

	@Test
	public void testCurrentNumber3() {
		// turn right 10 ticks
		int ticks = 10;
		lock.turnRight(ticks);
		ticks = 30;
		lock.turnLeft(ticks);
		ticks = 10;
		lock.turnRight(ticks);
		assertTrue("Current number doesnt not equal secret3", 30 == lock.getCurrentNumber());
	}

	@Test
	public void testGetIsValidSoFar() {
		// first test should show false
		assertTrue("Step 1: isValid has been initilized", false == lock.getIsValidSoFar());

		// move right a correct number - should now be true
		int ticks = 10;
		lock.turnRight(ticks);
		assertTrue("Step 2: No longer valid", true == lock.getIsValidSoFar());

		// move left the wrong amount and show again as false
		lock.turnLeft(ticks);
		assertTrue("Step 3: Showing as valid, when it should not be", false == lock.getIsValidSoFar());
	}

	@Test
	public void testGetLockState() {
		// initially lock state should be 0
		assertTrue("Step 1: Initilize Lock", 0 == lock.getLockState());

		int ticks = 10;
		lock.turnRight(ticks);
		assertTrue("Step 2: Check for state 1", 1 == lock.getLockState());

		lock.turnRight(ticks);
		assertTrue("Step 3: still should be 1, cuz numbers don't match", 1 == lock.getLockState());

	}

	@Test
	public void testReset() {
		// move to 1 than revert back to zero
		int ticks = 10;
		lock.turnRight(ticks);
		assertTrue("Step 1: Lock state should be 1", 1 == lock.getLockState());

		lock.reset();
		assertTrue("Step 2: Lock state should be restarted", 0 == lock.getLockState());

	}
}