package com.markus.desgin.mode.structural.adapter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public class HDMISlot implements ComputerSlot {
  @Override
  public void hdmi() {
    System.out.println("数据线插入 HDMI 接口成功！");
  }

  @Override
  public void usb() {
    throw new UnsupportedOperationException("该数据线不允许插入当前插槽");
  }

  @Override
  public String type() {
    return HDMI;
  }
}
