package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;


class AssignmentTests {

	@Test
	void test1_xvertex() {
		Vertex vertex = new Vertex(2,4,6);
		assertEquals(vertex.x,2);
	}
	
	@Test
	void test2_yvertex() {
		Vertex vertex = new Vertex(2,4,6);
		assertEquals(vertex.y,4);
	}
	
	@Test
	void test3_zvertex() {
		Vertex vertex = new Vertex(2,4,6);
		assertEquals(vertex.z,6);
	}
	
	@Test
	void test4_vertex() {
		Vertex vertex = new Vertex();
		assertNotEquals(vertex,null);
	}
	
	@Test
	void test5_equals() {
		Vertex vertex = new Vertex(2,4,6);
		assertTrue(vertex.equals(vertex));
	}
	
	@Test
	void test6_equals() {
		Vertex vertex = new Vertex(2,4,6);
		assertFalse(vertex.equals(null));
	}
	
	@Test
	void test7_equals() {
		Vertex vertex = new Vertex(2,4,6);
		assertFalse(vertex.equals(1));
	}
	
	@Test
	void test8_equals() {
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,4,6);
		assertFalse(vertex1.equals(vertex2));
	}
	
	@Test
	void test9_equals() {
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(2,3,6);
		assertFalse(vertex1.equals(vertex2));
	}
	
	@Test
	void test10_equals() {
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(2,4,5);
		assertFalse(vertex1.equals(vertex2));
	}
	
	@Test
	void test11_rotatexAxis() {
		Vertex vertex = new Vertex(2,4,6);
		vertex.rotateXAxis(Math.PI);
		Vertex newVertex = new Vertex(2,-4,-6);
		assertTrue(vertex.equals(newVertex));
	}
	
	@Test
	void test12_rotateyAxis() {
		Vertex vertex = new Vertex(2,4,6);
		vertex.rotateYAxis(Math.PI);
		Vertex newVertex = new Vertex(-2,4,-6);
		assertTrue(vertex.equals(newVertex));
	}
	
	@Test
	void test13_rotatezAxis() {
		Vertex vertex = new Vertex(2,4,6);
		vertex.rotateZAxis(Math.PI);
		Vertex newVertex = new Vertex(-2,-4,6);
		assertTrue(vertex.equals(newVertex));
	}
	
	@Test
	void test14_hashCode() {
		Vertex vertex = new Vertex(2,4,6);
		assertEquals(vertex.hashCode(), 516);
	}
	
	@Test
	void test15_toString() {
		Vertex vertex = new Vertex(2,4,6);
		String s = vertex.toString();
		assertEquals(s, "2.0 4.0 6.0");
	}
	
	@Test
	void test16_polygon() {
		Polygon polygon = new Polygon();
		assertNotEquals(polygon, null);
	}

	@Test
	void test17_polygonequals() {
		Polygon polygon = new Polygon();
		assertFalse(polygon.equals(null));
	}
	
	
	@Test
	void test18_polygonequals() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
		Vertex vertex = new Vertex(2,4,6);
		Polygon polygon1 = new Polygon(vertices);
		vertices.add(vertex);
		Polygon polygon2 = new Polygon(vertices);
		assertFalse(polygon1.equals(polygon2));
	}
	
	@Test
	void test19_polygonequals() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		Vertex vertex3 = new Vertex(5,6,7);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices2.add(vertex1);
		vertices2.add(vertex3);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		assertFalse(polygon1.equals(polygon2));
	}
	
	@Test
	void test20_polygonequals() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices2.add(vertex1);
		vertices2.add(vertex2);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		assertTrue(polygon1.equals(polygon2));
	}
	
	@Test
	void test21_polygonequals() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(2,4,6);
		vertices1.add(vertex1);
		Polygon polygon1 = new Polygon(vertices1);
		assertFalse(polygon1.equals(1));
	}

	@Test
	void test21_polygontransform() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		Vertex vertex3 = new Vertex(2,-4,-6);
		Vertex vertex4 = new Vertex(1,-2,-3);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		Polygon polygon1 = new Polygon(vertices1);
		polygon1.rotateXAxis(Math.PI);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon2 = new Polygon(vertices2);
		assertTrue(polygon1.equals(polygon2));
	}
	
	@Test
	void test21_hashCode() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		Polygon polygon1 = new Polygon(vertices1);
		assertEquals(polygon1.hashCode(),774);
	}
	
	@Test
	void test23_Mesh() {
		Mesh mesh = new Mesh();
		assertNotEquals(mesh, null);
	}
	
	@Test
	void test24_setreaderobj() {
		Mesh mesh = new Mesh();
		OBJMeshReader reader = new OBJMeshReader();
		mesh.setReader(reader);
		assertEquals(mesh.reader, reader);
	}
	
	@Test
	void test25_setreaderply() {
		Mesh mesh = new Mesh();
		PLYMeshReader reader = new PLYMeshReader();
		mesh.setReader(reader);
		assertEquals(mesh.reader, reader);
	}
	
	@Test
	void test25_setwriterobj() {
		Mesh mesh = new Mesh();
		OBJMeshWriter writer = new OBJMeshWriter();
		mesh.setWriter(writer);
		assertEquals(mesh.writer, writer);
	}
	
	@Test
	void test26_setwriterply() {
		Mesh mesh = new Mesh();
		PLYMeshWriter writer = new PLYMeshWriter();
		mesh.setWriter(writer);
		assertEquals(mesh.writer, writer);
	}
	
	@Test
	void test27_meshequals() {
		Mesh mesh = new Mesh();
		assertFalse(mesh.equals(null));
	}
	
	@Test
	void test28_meshequals() {
		Mesh mesh = new Mesh();
		assertFalse(mesh.equals(2));
	}
	@Test
	void test29_meshequals() {
		Mesh mesh1 = new Mesh();
		Mesh mesh2 = new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		HashSet<Polygon> polygons2 = new HashSet<Polygon>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		Vertex vertex3 = new Vertex(2,-4,-6);
		Vertex vertex4 = new Vertex(1,-2,-3);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		Polygon polygon1 = new Polygon(vertices1);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon2 = new Polygon(vertices2);
		polygons1.add(polygon1);
		polygons2.add(polygon2);
		mesh1.polygons = polygons1;
		mesh2.polygons = polygons2;
		assertFalse(mesh1.equals(mesh2));
	}
	
	@Test
	void test30_meshequals() {
		Mesh mesh1 = new Mesh();
		Mesh mesh2 = new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		HashSet<Polygon> polygons2 = new HashSet<Polygon>();
		Vertex vertex1 = new Vertex(2,4,6);
		Vertex vertex2 = new Vertex(1,2,3);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		Polygon polygon1 = new Polygon(vertices1);
		vertices2.add(vertex1);
		vertices2.add(vertex2);
		Polygon polygon2 = new Polygon(vertices2);
		polygons1.add(polygon1);
		polygons2.add(polygon2);
		mesh1.polygons = polygons1;
		mesh2.polygons = polygons2;
		assertTrue(mesh1.equals(mesh2));
	}
	
	@Test
	void test33_readfromfileobj() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.2,1.2,0.3);
		Vertex vertex2 = new Vertex(4.8,1.5,0.3);
		Vertex vertex3 = new Vertex(3.9,1.4,0.5);
		Vertex vertex4 = new Vertex(4.2,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		Mesh mesh1=new Mesh();
		Mesh mesh2=new Mesh();
		mesh2.polygons = polygons1;
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\example.obj");
		assertTrue(mesh1.equals(mesh2));
	}
	
	@Test
	void test34_readwritefromfileobj() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.1,1.2,0.3);
		Vertex vertex2 = new Vertex(4.9,1.5,0.3);
		Vertex vertex3 = new Vertex(3.8,1.4,0.5);
		Vertex vertex4 = new Vertex(4.1,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		Mesh mesh1=new Mesh();
		Mesh mesh2=new Mesh();
		mesh1.polygons = polygons1;
		mesh1.setWriter(new OBJMeshWriter());
		mesh1.writeToFile(null);
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile(null);
		assertFalse(mesh1.equals(mesh2));
	}
	@Test
	void test35_readfromfileply() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.2,1.2,0.3);
		Vertex vertex2 = new Vertex(4.8,1.5,0.3);
		Vertex vertex3 = new Vertex(3.9,1.4,0.5);
		Vertex vertex4 = new Vertex(4.2,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		Mesh mesh1=new Mesh();
		mesh1.setReader(new PLYMeshReader());
		mesh1.readFromFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\example.ply");
		assertEquals(mesh1.polygons, polygons1);
	}
	
	@Test
	void test36_readwritefromfileply() {
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.1,1.2,0.3);
		Vertex vertex2 = new Vertex(4.9,1.5,0.3);
		Vertex vertex3 = new Vertex(3.8,1.4,0.5);
		Vertex vertex4 = new Vertex(4.1,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		Mesh mesh1=new Mesh();
		Mesh mesh2=new Mesh();
		mesh1.polygons = polygons1;
		mesh1.setWriter(new PLYMeshWriter());
		mesh1.writeToFile(null);
		mesh2.setReader(new PLYMeshReader());
		mesh2.readFromFile(null);
		assertFalse(mesh1.equals(mesh2));
	}
	
	@Test
	void test37_hashCode() {
		Mesh mesh=new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.1,1.2,0.3);
		Vertex vertex2 = new Vertex(4.9,1.5,0.3);
		Vertex vertex3 = new Vertex(3.8,1.4,0.5);
		Vertex vertex4 = new Vertex(4.1,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons = new HashSet<Polygon>();
		polygons.add(polygon1);
		polygons.add(polygon2);
		mesh.polygons = polygons;
		assertEquals(mesh.hashCode(),655);
	}
	
	@Test
	void test38_transform() {
		Mesh mesh1=new Mesh();
		Mesh mesh2=new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.1,1.2,0.3);
		Vertex vertex2 = new Vertex(4.9,1.5,0.3);
		Vertex vertex3 = new Vertex(3.8,1.4,0.5);
		Vertex vertex4 = new Vertex(4.1,1.6,0.6);
		Vertex vertex5 = new Vertex(1,2,3);
		Vertex vertex6 = new Vertex(2,4,6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex4);
		vertices2.add(vertex5);
		vertices2.add(vertex6);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons = new HashSet<Polygon>();
		polygons.add(polygon1);
		polygons.add(polygon2);
		mesh1.polygons = polygons;
		mesh1.rotateXAxis(Math.PI);
		LinkedHashSet<Vertex> vertices3 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices4 = new LinkedHashSet<Vertex>();
		Vertex vertex7 = new Vertex(5.1,-1.2,-0.3);
		Vertex vertex8 = new Vertex(4.9,-1.5,-0.3);
		Vertex vertex9 = new Vertex(3.8,-1.4,-0.5);
		Vertex vertex10 = new Vertex(4.1,-1.6,-0.6);
		Vertex vertex11 = new Vertex(1,-2,-3);
		Vertex vertex12 = new Vertex(2,-4,-6);
		vertices3.add(vertex7);
		vertices3.add(vertex8);
		vertices3.add(vertex9);
		vertices4.add(vertex10);
		vertices4.add(vertex11);
		vertices4.add(vertex12);
		Polygon polygon3 = new Polygon(vertices1);
		Polygon polygon4 = new Polygon(vertices2);
		HashSet<Polygon> polygons2 = new HashSet<Polygon>();
		polygons2.add(polygon3);
		polygons2.add(polygon4);
		mesh2.polygons = polygons2;
		assertTrue(mesh1.equals(mesh2));
	}
	
	@Test
	void test39_writetofileobj() {
		Mesh mesh = new Mesh();
		Mesh mesh2 = new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.2,1.2,0.3);
		Vertex vertex2 = new Vertex(4.8,1.5,0.3);
		Vertex vertex3 = new Vertex(3.9,1.4,0.5);
		Vertex vertex4 = new Vertex(4.2,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		mesh.polygons = polygons1;
		mesh.setWriter(new OBJMeshWriter());
		mesh2.setReader(new OBJMeshReader());
		mesh.writeToFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\exampleobj");
		mesh2.readFromFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\exampleobj");
		assertEquals(polygons1,mesh2.polygons);
	}
	
	@Test
	void test40_writetofileply() {
		Mesh mesh = new Mesh();
		Mesh mesh2 = new Mesh();
		LinkedHashSet<Vertex> vertices1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices2 = new LinkedHashSet<Vertex>();
		Vertex vertex1 = new Vertex(5.2,1.2,0.3);
		Vertex vertex2 = new Vertex(4.8,1.5,0.3);
		Vertex vertex3 = new Vertex(3.9,1.4,0.5);
		Vertex vertex4 = new Vertex(4.2,1.6,0.6);
		vertices1.add(vertex1);
		vertices1.add(vertex2);
		vertices1.add(vertex3);
		vertices2.add(vertex2);
		vertices2.add(vertex3);
		vertices2.add(vertex4);
		Polygon polygon1 = new Polygon(vertices1);
		Polygon polygon2 = new Polygon(vertices2);
		HashSet<Polygon> polygons1 = new HashSet<Polygon>();
		polygons1.add(polygon1);
		polygons1.add(polygon2);
		mesh.polygons = polygons1;
		mesh.setWriter(new PLYMeshWriter());
		mesh2.setReader(new PLYMeshReader());
		mesh.writeToFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\exampleply");
		mesh2.readFromFile("C:\\Users\\shann\\eclipse-workspace\\assignment\\src\\assignment\\exampleply");
		assertEquals(polygons1,mesh2.polygons);
	}

	
	
	
}
