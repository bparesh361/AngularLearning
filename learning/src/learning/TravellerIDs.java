private List<TravelerIDs> createTravelIdsDetails(int adtCnt, int chdCnt, int infCnt, int ythCnt, int stuCnt, int lbrCnt, int vfrCnt) {
        List<TravelerIDs> travelerIdsList = new ArrayList<TravelerIDs>();
        int counter = 1;

        while (adtCnt > 0) {
            TravelerIDs adttrvl = new TravelerIDs();
            adttrvl.setAssociationID(MaxConnectorUtil.TRAVELER_CODE + counter);
            adttrvl.setPaxType(PaxType.ADT.toString());
            travelerIdsList.add(adttrvl);
            if (infCnt > 0) {
                TravelerIDs inftrvl = new TravelerIDs();
                inftrvl.setAssociationID(MaxConnectorUtil.TRAVELER_CODE + counter + MaxConnectorUtil.TRAVELER_INF_CODE);
                inftrvl.setPaxType(PaxType.INF.toString());
                travelerIdsList.add(inftrvl);
                infCnt--;
            }
            counter++;
            adtCnt--;
        }
        while (chdCnt > 0) {
            TravelerIDs chdval = new TravelerIDs();
            chdval.setAssociationID(MaxConnectorUtil.TRAVELER_CODE + counter);
            chdval.setPaxType(PaxType.CHD.toString());
            travelerIdsList.add(chdval);
            counter++;
            chdCnt--;
        }
        while (ythCnt > 0) {
            TravelerIDs ythval = new TravelerIDs();
            ythval.setAssociationID(MaxConnectorUtil.TRAVELER_CODE + counter);
            ythval.setPaxType(PaxType.YTH.toString());
            travelerIdsList.add(ythval);
            counter++;
            ythCnt--;
        }
        while (stuCnt > 0) {
            TravelerIDs stdval = new TravelerIDs();
            stdval.setAssociationID(MaxConnectorUtil.TRAVELER_CODE + counter);
            stdval.setPaxType("STD");
            travelerIdsList.add(stdval);
            counter++;
            stuCnt--;
        }
        return travelerIdsList;
    }