import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/11 22:40
 */
public class DemoTest {

    @Test
    public void test1(){
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        int i = c.get(Calendar.DAY_OF_MONTH);

        System.out.println(i);

    }
}
