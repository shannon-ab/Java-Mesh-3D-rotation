package assignment;
import java.util.*;

public interface MeshReader {
	public abstract HashSet<Polygon> read(String fileName) throws Exception;
}
