package assignment;

import java.util.*;
import java.io.*;


public class OBJMeshReader implements MeshReader{
	
	public OBJMeshReader() {
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
		
		for (int i = 0; i < lines.size(); i++) {
			
			String points[] = lines.get(i).split(" ");

			if (points[0].equals("f")){
				
				LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
				
				for (int j = 1; j < points.length; j++) {
					
					int v = Integer.parseInt(points[j]);
					
					String coord[] = lines.get(v-1).split(" ");

					double x = Double.parseDouble(coord[1]);
					double y = Double.parseDouble(coord[2]);
					double z = Double.parseDouble(coord[3]);
					
					Vertex vertex = new Vertex(x,y,z);

					vertices.add(vertex);
					
				}

				Polygon face = new Polygon(vertices);
				polygons.add(face);
				
				
			}

		}
		return polygons;
	}
}