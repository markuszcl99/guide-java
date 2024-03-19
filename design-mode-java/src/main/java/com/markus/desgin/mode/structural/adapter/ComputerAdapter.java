package com.markus.desgin.mode.structural.adapter;

import static com.markus.desgin.mode.structural.adapter.ComputerSlot.HDMI;
import static com.markus.desgin.mode.structural.adapter.ComputerSlot.USB;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public class ComputerAdapter implements AdvancedComputerSlot {

  ComputerSlot usb = new USBSlot();
  ComputerSlot hdmi = new HDMISlot();

  public ComputerAdapter() {

  }

  @Override
  public void typeC(String type) {

    switch (type) {
      case HDMI:
        hdmi.hdmi();
        break;
      case USB:
        usb.usb();
        break;
      default:
        throw new UnsupportedOperationException("拓展坞中没有该类型的数据插槽!");
    }
  }
}
