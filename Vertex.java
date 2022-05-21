package assignment;

public class Vertex extends GraphicalObject{
	double x;
	double y;
	double z;
	
	public Vertex() {
	}
	
	public Vertex(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void transform(double[][] trans) {
		double s;
		double[] coord = {x,y,z};
		double[] newcoord = new double[3];
		for (int i=0; i<3; i++) {
			s = 0;
			for (int j = 0; j < 3; j++) {
				s = s + trans[i][j]*coord[j];
			}
			newcoord[i] = s;
		}
		
		x = (double)Math.round(newcoord[0]*100000)/100000;
		y = (double)Math.round(newcoord[1]*100000)/100000;
		z = (double)Math.round(newcoord[2]*100000)/100000;
		
		
	}
	
	@Override
	public int hashCode() {
		return (int)(11*x+23*y+67*z);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (x != other.x | y != other.y | z != other.z)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String str = x + " " + y + " " + z;
		return str;
	}

}
