package kenny.account.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨小平
 * @date 2020/10/1 5:14
 * @description TODO
 */
public class StringToDateConvert implements Converter<String,Date> {

    @Override
    public Date convert(String str) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(str);
            return date;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}