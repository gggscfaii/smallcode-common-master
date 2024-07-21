package com.smallcode.common.util;

import com.smallcode.common.constant.Servers;
import com.smallcode.common.constant.Strings;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lenny
 * @Title: GidUtil
 * @ProjectName help
 * @Description: id生成
 * @date 2018-12-07 23:48
 **/
public class GidUtil {

  private static final AtomicInteger SERIAL = new AtomicInteger(Integer.MAX_VALUE);
  private static final int SHIFTS_FOR_TIMESTAMP = 31;
  private static final int MASK_FOR_PARTITION_AND_SERIAL = (1 << SHIFTS_FOR_TIMESTAMP) - 1;
  private static final int SHIFTS_FOR_PARTITION = 18;
  private static final int PARTITION =
      (Servers.IDC & ((1 << (SHIFTS_FOR_TIMESTAMP - SHIFTS_FOR_PARTITION)) - 1))
          << SHIFTS_FOR_PARTITION;
  private static final int MASK_FOR_SERIAL = (1 << SHIFTS_FOR_PARTITION) - 1;


  public static long next() {
    return next(TimeUtil.toSeconds());
  }

  public static long next(final long timeInSeconds, final AtomicInteger serial) {
    return min(timeInSeconds) | PARTITION | (serial.incrementAndGet() & MASK_FOR_SERIAL);
  }

  public static long next(final long timeInSeconds) {
    return min(timeInSeconds) | PARTITION | (SERIAL.incrementAndGet() & MASK_FOR_SERIAL);
  }

  public static long getTimeInSeconds(final long id) {
    return id >> SHIFTS_FOR_TIMESTAMP;
  }

  public static int getServerId(final long id) {
    return (int) ((id & PARTITION) >> SHIFTS_FOR_PARTITION);
  }

  public static long min(final long timeInSeconds) {
    return timeInSeconds << SHIFTS_FOR_TIMESTAMP;
  }

  public static long max(final long timeInSeconds) {
    return min(timeInSeconds) | MASK_FOR_PARTITION_AND_SERIAL;
  }

  public static String getFilePath(final long id) {
    return getFilePath(Strings.EMPTY, id);
  }

  public static String getFilePath(final String base, final long id) {
    final StringBuilder buff = new StringBuilder();
    if (base != "") {
      buff.append(base);

      if (base.charAt(base.length() - 1) != File.separatorChar) {
        buff.append(File.separatorChar);
      }
    }

    final Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(getTimeInSeconds(id) * 1000L);

    buff.append(cal.get(Calendar.YEAR));
    appendFilePathSegment(buff, cal.get(Calendar.MONTH) + 1);
    appendFilePathSegment(buff, cal.get(Calendar.DAY_OF_MONTH));
    appendFilePathSegment(buff, (int) (id % 100));
    return buff.toString();
  }

  private static void appendFilePathSegment(final StringBuilder buff, final int value) {
    buff.append(File.separatorChar);
    if (value < 10) {
      buff.append('0');
    }
    buff.append(value);
  }


}
