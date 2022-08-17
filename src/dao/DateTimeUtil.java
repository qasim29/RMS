
package dao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author dell
 */
public class DateTimeUtil {

    public static Date updateTime(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = sdf.format(date);
           //strDate = strDate + " " + time;
            sdf = new SimpleDateFormat("dd-MM-yyyy");
           //sdf = new SimpleDateFormat("dd-MM-yyyy ");
 
           return sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
