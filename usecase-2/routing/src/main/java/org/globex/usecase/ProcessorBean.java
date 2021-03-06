package org.globex.usecase;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.globex.globex.Account;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ProcessorBean {

    public void convertEntityToString(Exchange exchange) throws IOException {
        int c;
        StringBuffer buf = new StringBuffer();
        String response = null;



        exchange.getIn().setBody(response);
    }

    public Map<String, Object> defineNamedParameters(@Body Account ac) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("CLIENT_ID",ac.getClientId());
        map.put("SALES_CONTACT",ac.getSalesRepresentative());
        map.put("COMPANY_NAME",ac.getCompany().getName());
        map.put("COMPANY_GEO",ac.getCompany().getGeo());
        map.put("COMPANY_ACTIVE",ac.getCompany().isActive());
        map.put("CONTACT_FIRST_NAME",ac.getContact().getFirstName());
        map.put("CONTACT_LAST_NAME",ac.getContact().getLastName());
        map.put("CONTACT_ADDRESS",ac.getContact().getStreetAddr());
        map.put("CONTACT_CITY",ac.getContact().getCity());
        map.put("CONTACT_STATE",ac.getContact().getState());
        map.put("CONTACT_ZIP",ac.getContact().getZip());
        map.put("CONTACT_PHONE",ac.getContact().getPhone());
        map.put("CREATION_DATE",getCurrentTime());
        map.put("CREATION_USER","fuse_usecase");
        return map;
    }

    private static Timestamp getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimestamp = new Timestamp(now.getTime());
        return currentTimestamp;
    }
}
