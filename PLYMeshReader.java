package assignment;

import java.io.*;
import java.util.*;

public class PLYMeshReader implements MeshReader{
	
	public PLYMeshReader() {
	}
	
	public HashSet<Polygon> read(String fileName) throws Exception{
		HashSet<Polygon> polygons = new HashSet<Polygon>();
		BufferedReader sc = new BufferedReader(new FileReader(fileName));
		String line = sc.readLine();
		
		List<String> lines = new ArrayList<String>();
		while(line != null) {
			lines.add(line);
			line = sc.readLine();
		}
		sc.close();
		
		String elementvertex[] = lines.get(2).split(" ");

		String elementface[] = lines.get(6).split(" ");

		int noofvertices = Integer.parseInt(elementvertex[2]);

		int nooffaces = Integer.parseInt(elementface[2]);

		
		for (int i = 9+noofvertices; i< 9+noofvertices+nooffaces; i++) {

			String points[] = lines.get(i).split(" ");
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
			for (int j = 1; j < points.length; j++) {
				
				int v = 9 + Integer.parseInt(points[j]);

				String coord[] = lines.get(v).split(" ");

				double x = Double.parseDouble(coord[0]);
				double y = Double.parseDouble(coord[1]);
				double z = Double.parseDouble(coord[2]);

				Vertex vertex = new Vertex(x,y,z);
				vertices.add(vertex);

			}
			Polygon face = new Polygon(vertices);
			polygons.add(face);
			
		}

		return polygons;
	}
}
