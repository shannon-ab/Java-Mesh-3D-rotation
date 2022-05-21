package assignment;

public abstract class GraphicalObject {
	
	public abstract void transform(double[][] trans);
	
	public void rotateXAxis(double angle) {
		double[][] rotateX =  {{1,0,0},{0,Math.cos(angle),-Math.sin(angle)},{0,Math.sin(angle),Math.cos(angle)}};
		transform(rotateX);
	}
	
	public void rotateYAxis(double angle) {
		double[][] rotateY =  {{Math.cos(angle),0,Math.sin(angle)},{0,1,0},{-Math.sin(angle),0,Math.cos(angle)}};
		transform(rotateY);
	}
	public void rotateZAxis(double angle) {
		double[][] rotateZ =  {{Math.cos(angle),-Math.sin(angle),0},{Math.sin(angle),Math.cos(angle),0},{0,0,1}};
		transform(rotateZ);
	}
}
