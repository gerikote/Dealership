package utils.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String s) throws Exception {
        System.out.println("Unmarshalling date: " + s);
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(s).getTime());
    }

    @Override
    public String marshal(Date date) throws Exception {
        System.out.println("Marshalling date: " + date);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}

