package expressions;

public class AddAll extends ExpressionCollector {
	AddAll() {
		super();
	}

	@Override
	void evaluate() {
		int result = 0;
		if (this.isTypeCorrect()) {
			for (Expression e : this.getExpressions()) {
				e.evaluate();
				result += (int) e.getValue();
			}
		}
		this.value = result;
	}
}