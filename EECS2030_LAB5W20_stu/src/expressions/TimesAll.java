package expressions;

public class TimesAll extends ExpressionCollector {
	TimesAll() {
		super();
	}

	@Override
	void evaluate() {
		int result = 1;
		if (this.isTypeCorrect()) {
			for (Expression e : this.getExpressions()) {
				e.evaluate();
				result *= (int) e.getValue();
			}
		}
		this.value = result;
	}
}