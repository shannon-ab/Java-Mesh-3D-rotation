package assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PLYMeshWriter implements MeshWriter{
	public PLYMeshWriter() {
	}
	
	public void write(String fileName, HashSet<Polygon> polygons) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
		
		List<Vertex> verticeslist = new ArrayList<Vertex>();
		
		ArrayList<ArrayList<Integer> > faces = new ArrayList<ArrayList<Integer> >();
		
		int polygoncount = 0;
		int verticescount = 0;
		
		for (Polygon face: polygons) {
			ArrayList<Integer> vertices = new ArrayList<Integer>();
			for (Vertex vertice: face.vertices) {
				if (!verticeslist.contains(vertice)) {
					verticeslist.add(vertice);
					vertices.add(verticescount);
					verticescount++;
				}else {
					vertices.add(verticeslist.indexOf(vertice));
				}
			}
			faces.add(vertices);
			polygoncount++;
		}
		writer.write("ply\n");
		writer.write("format ascii 1.0\n");
		writer.write("element vertex "+ Integer.toString(verticescount)+"\n");
		writer.write("property float32 x\n");
		writer.write("property float32 y\n");
		writer.write("property float32 z\n");
		writer.write("element face " + Integer.toString(polygoncount) + "\n");
		writer.write("property list uint8 int32 vertex_indices\n");
		writer.write("end_header\n");
		
		for (Vertex vertex: verticeslist) {
			String s = vertex.toString() + "\n";
			writer.write(s);
		}
		
		for (ArrayList<Integer> face: faces) {
			int noofvertice = face.size();
			String points = Integer.toString(noofvertice);
			for (Integer point: face) {
				points = points + " " + Integer.toString(point);
			}
			writer.write(points+"\n");
		}
		writer.close();
	}

}
