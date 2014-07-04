package learning;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;

public class DateConvertor {

	public static void main(String[] args) {
		
		String strdate = "2012-06-10T21:02:21.959+02:00";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.US);
		try {
			Date date = format.parse(strdate);
			GregorianCalendar grCalendar = new GregorianCalendar();
			grCalendar.setTime(date);
			
				XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(grCalendar);
				DatatypeFactory df = DatatypeFactory.newInstance();
					
					XMLGregorianCalendar gcDate =
						    df.newXMLGregorianCalendarDate(calendar.getYear(),calendar.getMonth(),calendar.getDay(),DatatypeConstants.FIELD_UNDEFINED );
					XMLGregorianCalendar gcTime =
						    df.newXMLGregorianCalendarTime(
						        calendar.getHour(),
						        calendar.getMinute(),
						        calendar.getSecond(),
						        null,                               // no fraction
						        DatatypeConstants.FIELD_UNDEFINED );
					

					DateTime test = new DateTime();
					test.setDate(gcDate);
					test.setTime(gcTime);
					System.out.println("Date "+test.getDate());
					System.out.println("Time "+test.getTime());
					System.out.println(gcTime.toString());


			 		} catch (DatatypeConfigurationException e) {			
			e.printStackTrace();
		}catch (ParseException e) {			
			e.printStackTrace();
		}
	}
	public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
  



}
