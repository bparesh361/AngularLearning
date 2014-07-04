package learning;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class PassangerDtl {

	public static void main(String args[]) throws Exception {		

		int adult = 3;
		int infant = 2;		
		int chdint = 1;
		int ythCnt =2;
		int stuCnt=1;
	//	String xml = getTraverllerIds(adult, infant,chdint);
		List<TravellerIDs> xml = getTraverllerIds(adult, infant,chdint,ythCnt,stuCnt);
		
		for(TravellerIDs id : xml){
			System.out.println(id.getAttributeIDs() +":"+id.getPaxType());
			//System.out.println(id.getPaxType());
			
		}
		
	}
	
	public static List<TravellerIDs> getTraverllerIds(int adult, int infant,int chdint,int ythCnt,int stuCnt) throws Exception {
//		JAXBContext context = JAXBContext.newInstance(learning.TravellerIDs.class);
//		Marshaller marshaller = context.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		StringWriter writer = new StringWriter();
		if(infant>adult){
			throw new IllegalArgumentException("Infant Count can not be greater than Adult Count.");
		}
		//TravellerIDs[] ids = new TravellerIDs[adult+infant+chdint+ythCnt+stuCnt];
		List<TravellerIDs> travellerIDs = new ArrayList<TravellerIDs>();
		int counter=1;
		//int pos=0;
		while(adult>0){
			TravellerIDs adttrvl = new TravellerIDs();
			adttrvl.setAttributeIDs("T" + counter);
			adttrvl.setPaxType(PAX.ADT.toString());
			//marshaller.marshal(adttrvl, writer);
			travellerIDs.add(adttrvl);
			//ids[pos++] = adttrvl;
			if(infant>0){
				TravellerIDs inftrvl = new TravellerIDs();
				inftrvl.setAttributeIDs("T" + counter + ".1");
				inftrvl.setPaxType(PAX.INF.toString());
				//ids[pos++] = inftrvl;
				//marshaller.marshal(inftrvl, writer);
				travellerIDs.add(inftrvl);
				infant--;
			}
			counter++;
			adult--;
			
		}		
		while(chdint >0){
			TravellerIDs chdval = new TravellerIDs();
			chdval.setAttributeIDs("T" + counter);
			chdval.setPaxType(PAX.CHD.toString());
		//	marshaller.marshal(chdval, writer);
			travellerIDs.add(chdval);
			//ids[pos++] = chdval;
			counter++;
			chdint--;
		}
		
		while(ythCnt >0){
			TravellerIDs ythval = new TravellerIDs();
            ythval.setAttributeIDs("T" + counter);
            ythval.setPaxType(PAX.YTH.toString());
           // ids[pos++] = ythval;
            travellerIDs.add(ythval);            
            counter++;
            ythCnt--;
    }
        while(stuCnt >0){
        	TravellerIDs stdval = new TravellerIDs();
            stdval.setAttributeIDs("T" + counter);
            stdval.setPaxType(PAX.STD.toString());
          //  ids[pos++] = stdval;
            travellerIDs.add(stdval);            
            counter++;
            stuCnt--;
    }
		//return writer.toString();		
		return travellerIDs;
	}
}
