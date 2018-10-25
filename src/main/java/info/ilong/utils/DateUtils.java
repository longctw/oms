package info.ilong.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public final static String YYYYMM = "yyyyMM";
	public final static String YYYYMMDD = "yyyyMMdd";
	
	
	public static String getFormatString(String patten){
		SimpleDateFormat dateFormat = new SimpleDateFormat(patten);
		return dateFormat.format(new Date());
	}
}
