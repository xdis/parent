package com.zyxy.common.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yihao on 2017/11/27.
 */
public class IOUtil {
    public static final String readString(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return new String(message);
            } catch (IOException e) {
                // Ignore
                e.printStackTrace();
            }
        }
        return "";
    }
}
