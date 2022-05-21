package assignment;
import java.util.*;

public interface MeshWriter {
	public abstract void write(String fileName, HashSet<Polygon> polygons) throws Exception;
}
