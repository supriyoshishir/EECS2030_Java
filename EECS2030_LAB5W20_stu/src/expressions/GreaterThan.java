package expressions;

public class GreaterThan extends Expression {
	GreaterThan(int left, int right) {
		super(left, right);
	}

	@Override
	void evaluate() {
		this.value = this.left > this.right;
	}
}