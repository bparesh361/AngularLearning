package learning;

import javax.xml.datatype.XMLGregorianCalendar;

public class DateTime {
	protected XMLGregorianCalendar date;
    protected XMLGregorianCalendar time;

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    public XMLGregorianCalendar getTime() {
        return time;
    }

    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }
}
