package learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateTest {

	public static void main(String[] args) throws ParseException {

		try {
			String strdate = "2012-06-10T21:02:21.959+02:00";
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.clear();

			Calendar parsedCalendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss", Locale.US);
			Date rawDate = format.parse(strdate);
			parsedCalendar.setTime(rawDate);

			calendar.set(parsedCalendar.get(Calendar.YEAR),
					parsedCalendar.get(Calendar.MONTH),
					parsedCalendar.get(Calendar.DATE));
			XMLGregorianCalendar xmlCalendar = datatypeFactory
					.newXMLGregorianCalendar(calendar);
			xmlCalendar.setTimezone( DatatypeConstants.FIELD_UNDEFINED );
			
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
