package com.smallcode.common.entity;

import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;


/**
 * @author lenny
 * @Title: PageBean
 * @ProjectName help
 * @date 2018-12-0723:23
 **/
@Builder
public class PageBean<T> implements Serializable {


  private int pageNo;

  private int pageSize;

  private long totalCount;

  public PageBean() {
  }


  public PageBean(List<T> list) {
    if (list instanceof Page) {
      Page<T> page = (Page<T>) list;
      this.pageNo = page.getPageNum();
      this.pageSize = page.getPageSize();
      this.totalCount = page.getTotal();
    }
  }

  public PageBean(int pageNo, int pageSize, long totalCount) {
    this.pageNo = pageNo;
    this.pageSize = pageSize;
    this.totalCount = totalCount;
  }

  public static PageBean empty() {
    return new PageBean();
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }
}
