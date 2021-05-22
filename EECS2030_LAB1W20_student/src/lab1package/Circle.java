package lab1package;

import java.awt.Color;

public class Circle {

	private double radius;
	private Color color;

	public Circle() {
		this.radius = 1.0;
		this.color = Color.BLUE;
	}

	public Circle(double radius, Color color) {
		if (radius < 0.0) {
			throw new IllegalArgumentException();
		}

		this.radius = radius;

		this.color = color;
	}

	public double getDouble() {
		return this.radius;
	}

	public void setRadius(double radius) {

		this.radius = radius;
	}

	public Color get() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
