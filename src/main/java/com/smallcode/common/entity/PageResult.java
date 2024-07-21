package com.smallcode.common.entity;

import com.github.pagehelper.Page;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author lenny
 * @Title: PageResult
 * @ProjectName smallcode-mall-common
 * @Description: 分页返回
 * @date 2019-05-10 22:24
 **/
@Data
public class PageResult<T> {


  private PageBean pageBean;

  private List<T> items;

  public static <T> PageResult<T> page(Page<T> page) {
    PageBean pageBean = new PageBean(page);

    PageResult<T> pageResult = new PageResult<>();
    pageResult.setPageBean(pageBean);
    pageResult.setItems(page.getResult());

    return pageResult;
  }

  public static <T> PageResult<T> page(Page page, List<T> items) {
    PageBean pageBean = new PageBean(page);

    PageResult<T> pageResult = new PageResult<>();
    pageResult.setPageBean(pageBean);
    pageResult.setItems(items);
    return pageResult;
  }


  public static <T> PageResult<T> empty() {
    PageBean pageBean = PageBean.empty();

    PageResult<T> pageResult = new PageResult<>();
    pageResult.setPageBean(pageBean);
    pageResult.setItems(new ArrayList<>());
    return pageResult;
  }

}
