package expressions;

public class LessThan extends Expression {
	LessThan(int left, int right) {
		super(left, right);
	}

	@Override
	void evaluate() {
		this.value = this.left < this.right;
	}
}