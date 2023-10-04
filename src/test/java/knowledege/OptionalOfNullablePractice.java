package knowledege;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * showing working of Optional.ofNullable()
 * @author YASH MULKALWAR
 *
 */
public class OptionalOfNullablePractice {
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("name", "yash");
		
		System.out.println(map.get("idd")); // gives null
		
		Optional idd = Optional.ofNullable(map.get("idd"));
		if (idd.isPresent()) {
			System.out.println("Id is "+idd);
		}
		else
			System.out.println("Please enter the correct key !!!!!");
	}

}
