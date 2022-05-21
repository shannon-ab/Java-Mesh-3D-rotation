package assignment;
import java.util.*;

public class Mesh extends GraphicalObject{
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	public Mesh() {
		polygons = new HashSet<Polygon>();
	}
	
	public void setReader(MeshReader reader) {
		this.reader = reader;
	}
	
	public void setWriter(MeshWriter writer) {
		this.writer= writer;
	}
	
	public void readFromFile(String fileName){
		try {
			polygons = reader.read(fileName);
		}catch(Exception e) {
			System.out.println("file not found.");
		}
	}
	
	public void writeToFile(String fileName){
		try {
			writer.write(fileName, polygons);
		}catch(Exception e) {
			System.out.println("write to file failed.");
		}
	}
	
	public void transform(double[][] trans) {
		for (Polygon polygon: polygons) {
			polygon.transform(trans);
		}
	}
	
	@Override
	public int hashCode() {
		int total = 0;
		for (Polygon polygon: polygons) {
			total = total + polygon.hashCode();
		}
		return (int)total;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesh other = (Mesh) obj;
		int i=0;
		for (Polygon polygon: polygons) {
			for (Polygon otherpolygon: other.polygons) {
				if (polygon.equals(otherpolygon)) {
					i++;
				}
			}
		}
		if(i != polygons.size()) {
			return false;
		}
		return true;
	}
}
