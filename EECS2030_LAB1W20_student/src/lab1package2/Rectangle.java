package lab1package2;

public class Rectangle {
	private int height;
	private int width;
	private int area;

	public Rectangle() {
		this.height = 0;
		this.width = 0;
		this.area = 0;
	}

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
		this.area = this.getA();

	}

	public int getH() {
		return this.height;

	}

	public int getW() {
		return this.width;

	}

	public int getA() {
		return this.area;
	}

	public void setH(int height) {
		this.height = height;

	}

	public void setW(int width) {
		this.width = width;

	}

	public void setA() {
		this.area = this.height * this.width;
	}

	public String toString() {
		int area = this.height * this.width;
		return "Height: " + this.height + "Width: " + this.width + "Area: " + area;
	}
}