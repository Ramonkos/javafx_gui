package praktikum;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    public long getTimeStampFromLocalDate(LocalDate YYYY_MM_DD) {
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = YYYY_MM_DD.atStartOfDay(zoneId).toEpochSecond();
        return epoch;
    }

    public String getLocalDateStringFromTimeStamp(long timeStampSeconds) {
        long timeStampMilli = timeStampSeconds * 1000;
        Date date = new Date(timeStampMilli);
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }
}
