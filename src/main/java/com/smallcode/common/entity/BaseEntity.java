package com.smallcode.common.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lenny
 * @Title: BaseEntity
 * @ProjectName smallcode-mall
 * @Description: 基础类
 * @date 2019-01-02 15:17
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
public class BaseEntity implements Serializable {


  private Long id;

  private Date createTime = new Date();

  private Date modifyTime = new Date();


}
