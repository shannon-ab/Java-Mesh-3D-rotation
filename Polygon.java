package assignment;
import java.util.*;

public class Polygon extends GraphicalObject{
	LinkedHashSet<Vertex> vertices;
	
	public Polygon() {
	}
	public Polygon(LinkedHashSet<Vertex> vertices) {
		this.vertices = new LinkedHashSet<Vertex>();
		for (Vertex vertex: vertices) {
			this.vertices.add(vertex);
		}
	}
	
	public void transform(double[][] trans) {
		for (Vertex vertex: vertices) {
			vertex.transform(trans);
		}
			
	}
	
	@Override
	public int hashCode() {
		double total = 0;
		for (Vertex vertex: vertices) {
			total = total + vertex.hashCode();
		}
		
		return (int)(total);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		if (other.vertices.size() != vertices.size()) {
			return false;
		}
		int i = 0;
		for (Vertex vertex: vertices) {
			for (Vertex othervertex: other.vertices) {
				if (vertex.equals(othervertex)) {
					i++;
				}
			}
		}
		if(i != vertices.size()) {
			return false;
		}
		return true;
	}
}
