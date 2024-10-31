package com.documentador.casodeuso.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utiles {

    public Integer getFechaActual () {
        long ts = System.currentTimeMillis() / 1000;
        Date currentDate = new Date(ts);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String fechaStr = dateFormat.format(currentDate);
        return  Integer.getInteger(fechaStr.replace("-",""));
    }
}
