package com.techacademy;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    // 仕様1
    @GetMapping("/dayofweek/{var1}")
    public String dispDayOfWeek(@PathVariable String var1) {
        //yyyymmddの取得
        //Date selectDay = new Date(yyyymmdd);
        String year = var1.substring(0,4);
        String month = var1.substring(4,6);
        String day = var1.substring(6,8);
        //日付の取得
        LocalDate ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        DayOfWeek w = ld.getDayOfWeek();

        // データ型の変更（yyyymmdd → week）
        //String ld = LocalDate.format(DateTimeFormatter.ofPattern("EEEE"));
        // 出力
        // String.valueOf(ld);
        
        //SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.US);
        //String result = dateFormat.format(yyyymmdd);
        //Date result = dateFormat.parse(selectDay); 
        
        return w.getDisplayName(TextStyle.FULL, Locale.US);
        //return String.valueOf (ld.getDayOfWeek());
    }

    // 仕様2
    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public int calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return res;
    }
}