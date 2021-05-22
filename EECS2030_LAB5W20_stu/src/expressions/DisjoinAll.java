package expressions;

public class DisjoinAll extends ExpressionCollector {
	DisjoinAll() {
		super();
	}

	@Override
	void evaluate() {
		boolean result = false;
		if (this.isTypeCorrect()) {
			for (Expression e : this.getExpressions()) {
				e.evaluate();
				result = (boolean) e.getValue() || result;
			}
		}
		this.value = result;
	}
}