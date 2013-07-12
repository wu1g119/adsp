package cn.com.softvan.common;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * 服务端检查错误信息取得
 *
 */
public class MessageUtils {

    /**
     * 服务端检查错误信息取得
     * @return
     */
    public static String getMessage(String mesId, Object[] param) {
        
        if (StringUtils.isBlank(mesId) || param == null) {
            return null;
        }
        
        if (ResourceBundle.getBundle("message_zh") == null) {
            return null;
        }
        
        return MessageFormat.format(ResourceBundle.getBundle("message_zh").getString(mesId),
            (Object[]) param);
    }
}
