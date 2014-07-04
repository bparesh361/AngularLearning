package learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLToDateTimeConvertor {

	public static void main(String[] args) {
		String strdate = "2014-08-14";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		String strTime = "15:20";

		try {
			Date date = format.parse(strdate);
			System.out.println(date);
			System.out.println(format.format(date));
			GregorianCalendar grCalendar = new GregorianCalendar();
			grCalendar.setTime(date);

			XMLGregorianCalendar calendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(grCalendar);
			System.out.println(calendar);
			

		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
