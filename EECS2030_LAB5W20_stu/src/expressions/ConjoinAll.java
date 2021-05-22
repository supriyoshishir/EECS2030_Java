package expressions;

public class ConjoinAll extends ExpressionCollector {
	ConjoinAll() {
		super();
	}

	@Override
	void evaluate() {
		boolean result = true;
		if (this.isTypeCorrect()) {
			for (Expression e : this.getExpressions()) {
				e.evaluate();
				result = (boolean) e.getValue() == result;
			}
		}
		this.value = result;
	}
}