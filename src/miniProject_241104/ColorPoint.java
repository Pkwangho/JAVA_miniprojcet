package miniProject_241104;

class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public ColorPoint() {
		super(0, 0);
		this.color = "BLACK";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPoint(int x, int y) {
		move(x, y);
	}

	public void show() {
		System.out.println(color + "색으로 (" + getX() + ", " + getY() + ")");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setPoint(10, 20);
		cp.setColor("GREEN");
		cp.show();
	}

}
