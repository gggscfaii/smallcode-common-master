package com.smallcode.common.util;

import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * @author lenny
 * @Title: FileUtil
 * @ProjectName smallcode-mall-common
 * @Description: 文件
 * @date 2019-05-11 09:17
 **/
public class FileUtil {


  public static boolean isImage(java.io.File imageFile) {
    if (!imageFile.exists()) {
      return false;
    }
    Image img = null;
    try {
      img = ImageIO.read(imageFile);
      if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    } finally {
      img = null;
    }
  }

}
