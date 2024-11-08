package Source_code;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class code {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(formatter.format(calendar.getTime()));
		System.out.println("Su Mo Tu We Th Fr Sa");
		
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		calendar.set(Calendar.DATE, 1);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		for(int i = 1; i < dayOfWeek; i++) {
			System.out.print("   ");
		}
		
		for(int i = 1; i <= lastDay; i++) {
			System.out.printf("%02d ", i);
			if(dayOfWeek % 7 == 0) {
				System.out.println();
			}
			dayOfWeek++;
		}
	}

}
