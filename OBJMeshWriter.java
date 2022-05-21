package assignment;

import java.io.*;
import java.util.*;

public class OBJMeshWriter implements MeshWriter{
	
	public OBJMeshWriter() {
	}
	
	public void write(String fileName, HashSet<Polygon> polygons) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
		
		List<Vertex> verticeslist = new ArrayList<Vertex>();
		
		ArrayList<ArrayList<Integer> > faces = new ArrayList<ArrayList<Integer> >();
		
		int verticescount = 0;

		for (Polygon face: polygons) {
			ArrayList<Integer> vertices = new ArrayList<Integer>();
			for (Vertex vertex: face.vertices) {
				if (!verticeslist.contains(vertex)) {
					verticeslist.add(vertex);
					vertices.add(verticescount+1);
					verticescount++;
				}else {
					vertices.add(verticeslist.indexOf(vertex)+1);
				}
			}
			faces.add(vertices);
		}

		for (Vertex vertex: verticeslist) {
			String s = "v " + vertex.toString() + "\n";
			writer.write(s);
		}
		
		for (ArrayList<Integer> face: faces) {
			String points = "f";
			for (Integer point: face) {
				points = points + " " + Integer.toString(point);
			}
			writer.write(points+"\n");
		}
		writer.close();
		
	}

}
