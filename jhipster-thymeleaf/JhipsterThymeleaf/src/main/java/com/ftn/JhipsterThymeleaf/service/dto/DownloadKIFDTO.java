package com.ftn.JhipsterThymeleaf.service.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadKIFDTO {

    private String dateFrom;
    private String dateTo;

    public Date getDateFrom() throws ParseException {
        return parseDate(dateFrom, "yyyy-MM-dd");
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() throws ParseException {
        return parseDate(dateTo, "yyyy-MM-dd");
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    private Date parseDate(String date, String format) throws ParseException {
        if(date == null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }
}
