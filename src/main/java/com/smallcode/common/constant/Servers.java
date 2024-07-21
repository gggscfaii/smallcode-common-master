package com.smallcode.common.constant;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @author lenny
 * @Title: Servers
 * @ProjectName smallcode-mall
 * @date 2019-01-02 16:28
 **/
public class Servers {

  public static final int ID = getId();

  public static final String PROJECT_ID = "platform-project.id";

  public static final String PROPERTY_IDC = "server.idc";
  public static final String PROPERTY_NODE = "server.id";
  public static final String PROPERTY_PROJECT = "server.project";


  public static final int IDC = Integer.valueOf(System.getProperty(PROPERTY_IDC, "1"));


  public static int getId() {
    InputStream is = null;
    try {
      is = Servers.class.getClassLoader().getResourceAsStream(PROJECT_ID);
      if (is != null) {
        byte[] buff = new byte[32];
        int len = is.read(buff);
        if (len > 0) {
          return Integer.valueOf(new String(Arrays.copyOf(buff, len)).trim());
        }
      }
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      try {
        if (is != null) {
          is.close();
        }
      } catch (Throwable e) {
      }
    }
    return 0;
  }


}
