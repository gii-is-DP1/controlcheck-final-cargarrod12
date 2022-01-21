package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CareFormatter implements Formatter<Care>{

    @Override
    public String print(Care object, Locale locale) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
