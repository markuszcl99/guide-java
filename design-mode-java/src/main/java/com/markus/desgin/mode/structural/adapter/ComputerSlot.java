package com.markus.desgin.mode.structural.adapter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public interface ComputerSlot {

  String HDMI = "HDMI";
  String USB = "USB";

  void hdmi();

  void usb();

  String type();
}
