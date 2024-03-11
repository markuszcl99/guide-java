package com.markus.desgin.mode.structure.adapter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public class USBSlot implements ComputerSlot {
  @Override
  public void hdmi() {
    throw new UnsupportedOperationException("该数据线不允许插入当前插槽");
  }

  @Override
  public void usb() {
    System.out.println("数据线插入 USB 接口成功！");
  }

  @Override
  public String type() {
    return USB;
  }
}
