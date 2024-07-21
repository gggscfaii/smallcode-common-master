package com.smallcode.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenny
 * @Title: TimeUtil
 * @ProjectName help
 * @date 2018-12-07 23:52
 **/
public class TimeUtil {


  public static int toSeconds() {
    return (int) (System.currentTimeMillis() / 1000);
  }


  public static Integer toInt() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String dateString = formatter.format(new Date());
    return Integer.parseInt(dateString);
  }
}
