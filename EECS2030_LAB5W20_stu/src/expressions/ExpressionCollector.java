package expressions;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCollector {

	protected List<Expression> expressions;
	protected Object value;
	protected String defaultValue;

	ExpressionCollector() {
		this.expressions = new ArrayList<Expression>();
	}

	/**
	 * Add a new expression.
	 * 
	 * @param e
	 *            an expression
	 */
	void addExpression(Expression e) {
		this.expressions.add(e);
	}

	/**
	 * Add a new expression.
	 * 
	 * @param left
	 *            integer value of the left operand
	 * @param op
	 *            operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right
	 *            integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		Expression e;
		switch (op) {
		case "+":
			e = new Addition(left, right);
			break;
		case "-":
			e = new Subtraction(left, right);
			break;
		case "*":
			e = new Multiplication(left, right);
			break;
		case ">":
			e = new GreaterThan(left, right);
			break;
		case "<":
			e = new LessThan(left, right);
			break;
		case "==":
			e = new Equal(left, right);
			break;
		default:
			e = new Expression(left, right);
			break;
		}
		this.addExpression(e);
	}

	/**
	 * sub-routine that can be used to check if this is type correct true if e is
	 * one of the three classes, or their subclasses (if any) so use instanceof,
	 * instead of getClassName()
	 */
	private boolean isArithmetic(Expression e) {
		return e instanceof Addition || e instanceof Subtraction || e instanceof Multiplication;
	}

	/**
	 * sub-routine that can be used to check if this is type correct true if e is
	 * one of the three classes, or their subclasses (if any)
	 */
	private boolean isRelation(Expression e) {
		return e instanceof Equal || e instanceof GreaterThan || e instanceof LessThan;
	}

	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be
	 * integer expressions (i.e., Addition, Subtraction, Multiplication). If this
	 * collection is ConjoinAll or DisjoinAll, then all stored expressions must be
	 * boolean expressions (i.e., GreaterThan, LessThan, Equal)
	 * 
	 * @return whether it is possible to evaluate the stored collection of
	 *         expressions.
	 */
	boolean isTypeCorrect() {
		boolean isArithmetic = true;
		boolean isRelation = (this.expressions.size() > 0) ? true : false;
		for (Expression e : this.expressions) {
			if (isArithmetic) {
				isArithmetic = this.isArithmetic(e);
			}
			if (isRelation) {
				isRelation = this.isRelation(e);
			}
		}
		return isArithmetic ^ isRelation;
	}

	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to
	 * `evaluate()`).
	 * 
	 * @return the last evaluation result.
	 */
	Object getValue() {
		return this.value;
	}

	/**
	 * Obtain the list of stored expressions, as an array.
	 * 
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		Expression[] exps = new Expression[this.expressions.size()];
		int i = 0;
		for (Expression e : this.expressions) {
			exps[i] = e;
			i++;
		}
		return exps;
	}

	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by
	 * `getValue()`.
	 */
	void evaluate() {
		// Hint: Leave this empty and override it in all subclasses such as Addition,
		// GreaterThan.
	}

	/**
	 * Override the equals method. Two expression collectors are equals if: 1) They
	 * are both type correct 2) Their evaluation results are identical
	 * 
	 * @return whether or not the two expression collectors are equal.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		ExpressionCollector other = (ExpressionCollector) obj;
		if (this.isTypeCorrect() && other.isTypeCorrect()) {
			return (this.getValue() == other.getValue());
		} else {
			return false;
		}

	}

}
