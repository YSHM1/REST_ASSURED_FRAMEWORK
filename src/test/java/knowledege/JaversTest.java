package knowledege;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

public class JaversTest {
	public static void main(String[] args) {

		JaversExample example1 = new JaversExample(1, "yash");
		JaversExample example2 = new JaversExample(2, "yash");
		
		Javers javers = JaversBuilder.javers().build();
		Diff diff = javers.compare(example1, example2);
		System.out.println("Comparing example1 with example2");
		System.out.println(diff.prettyPrint());
	
		System.out.println();
		System.out.println();
		
		Diff diff2 = javers.compare(example2, example1);
		System.out.println("Comparing example2 with example1");
		System.out.println(diff2.prettyPrint());
		
		System.out.println("diff changes ---> "+diff.getChanges());
		System.out.println("diff2 changes ---> "+diff2.getChanges());

	}
}
