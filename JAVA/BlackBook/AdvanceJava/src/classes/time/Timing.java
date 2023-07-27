package classes.time;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Timing {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.parse("1996-06-23", DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse("2023-07-27", DateTimeFormatter.ISO_LOCAL_DATE);
		
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		System.out.println(diff.toDays()/365+" "+diff.toDays()%365);
	}
}
