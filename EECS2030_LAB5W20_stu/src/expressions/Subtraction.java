package expressions;

public class Subtraction extends Expression {
	Subtraction(int left, int right) {
		super(left, right);
	}

	@Override
	void evaluate() {
		this.value = this.left - this.right;
	}
}