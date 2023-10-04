package restAssured.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtil {
	
	public static int getCurrentYear() {
		return LocalDate.now().getYear();
	}

}
