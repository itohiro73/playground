package jp.itohiro.playground.datetime;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeKata {
    @Test
    public void testDataTimeKata() {
        LocalDateTime date1 = LocalDateTime.of(2015, 7, 3, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2016, 3, 26, 0, 0);
        LocalDate date = LocalDate.of(1980, 7, 3);
        LocalDate mao = LocalDate.of(2009, 3, 26);
        LocalDateTime maoBirth = LocalDateTime.of(2009, 3, 26, 0, 0);
        Period period = date1.toLocalDate().until(date2.toLocalDate());

        System.out.println(period.getDays());

        ZonedDateTime japanTime = date.atStartOfDay(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime zonedDateTime = date2.atZone(ZoneId.of("America/New_York"));

        Assert.assertEquals(date1, date2.minusMonths(8).minusDays(23));
        Assert.assertEquals("Asia/Tokyo", japanTime.getZone().getId());

        Locale jpLocale = Locale.JAPAN;
        Chronology wareki = Chronology.ofLocale(jpLocale);

        JapaneseDate myBirthDay = JapaneseDate.of(JapaneseEra.SHOWA, 55, 7, 3);
        JapaneseDate myBirthDay2 = JapaneseDate.of(1980, 7, 3);
        JapaneseDate myBirthDay3 = JapaneseDate.from(date);
        JapaneseDate maoBirthDay = JapaneseDate.from(maoBirth);


//        ChronoLocalDate myBirthday = wareki.date(JapaneseEra.SHOWA, 55, 7, 3);
        System.out.println(myBirthDay);
        System.out.println(myBirthDay2);
        System.out.println(myBirthDay3);
        System.out.println(maoBirthDay);
        System.out.println(DateTimeFormatter.ofPattern("Gyy年MM月dd日", Locale.JAPAN).format(maoBirthDay));
        System.out.println(DateTimeFormatter.ofPattern("G", Locale.JAPAN).format(maoBirthDay));
        System.out.println(DateTimeFormatter.ofPattern("E", Locale.JAPAN).format(maoBirthDay));
        System.out.println(DateTimeFormatter.ofPattern("GGGG", Locale.JAPAN).format(maoBirthDay));
        System.out.println(DateTimeFormatter.ofPattern("EEEE", Locale.JAPAN).format(maoBirthDay));
        System.out.println(DateTimeFormatter.ofPattern("M月d日（E）", Locale.JAPAN).format(maoBirthDay));
    }

}
