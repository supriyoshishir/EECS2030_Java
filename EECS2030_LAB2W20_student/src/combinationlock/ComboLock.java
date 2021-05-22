package combinationlock;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	private int secret1;
	private int secret2;
	private int secret3;

	// 0: nothing entered, 1: secret1 done, 2: secret2 done,
	// 3: secret3 done and unlocked
	private int lockState;

	private int currentNumber;
	private boolean validSoFar;

	/**
	 * Initializes the combination of the lock.
	 * 
	 * @param secret1
	 *            first number to turn right to
	 * @param secret2
	 *            second number to turn left to
	 * @param secret3
	 *            third number to turn right to
	 */
	public ComboLock(int secret1, int secret2, int secret3) {
		this.secret1 = secret1;
		this.secret2 = secret2;
		this.secret3 = secret3;
	}

	/**
	 * Resets the state of the lock so that it can be opened again.
	 */
	public void reset() {
		this.lockState = 0;
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks
	 *            number of ticks to turn left
	 */
	public void turnLeft(int ticks) {
		int temp = this.currentNumber - ticks;
		this.currentNumber = (temp < 0) ? (39 + 1) + temp : temp;

		if (this.lockState == 1) {
			check(this.secret2);
		}
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks
	 *            number of ticks to turn right
	 */
	public void turnRight(int ticks) {
		int temp = this.currentNumber + ticks;
		this.currentNumber = (temp > 39) ? temp - (39 + 1) : temp;

		if (this.lockState == 0) {
			check(this.secret1);
		} else if (this.lockState == 2 && this.validSoFar) {
			check(this.secret3);
		}
	}

	/**
	 * Returns true if the lock can be opened now
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		return (this.lockState == 3) ? this.validSoFar : false;
	}

	private void check(int secret) {
		if ((this.currentNumber == secret)) {
			this.lockState++;
			this.validSoFar = true;
		} else {
			this.validSoFar = false;
		}
	}

	public Integer getCurrentNumber() {
		return this.currentNumber;
	}

	public boolean getIsValidSoFar() {
		return this.validSoFar;
	}

	public Integer getLockState() {
		return this.lockState;
	}
}
