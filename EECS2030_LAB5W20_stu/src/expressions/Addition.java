package expressions;

public class Addition extends Expression {

	public Addition(int left, int right) {
		super(left, right);
	}

	@Override
	void evaluate() {
		this.value = this.left + this.right;
	}
}