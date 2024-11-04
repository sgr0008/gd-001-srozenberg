package com.documentor.backend.casodeuso.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Implementacion de utiles / funciones de formateo de datos en general.
 */
public class Utiles {
    /***
     * @return Fecha actul como int ,formato yyyyMMDD
     */
    public Integer getFechaActual () {
        long ts = System.currentTimeMillis() / 1000;
        Date currentDate = new Date(ts);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String fechaStr = dateFormat.format(currentDate);
        return  Integer.getInteger(fechaStr.replace("-",""));
    }
}
