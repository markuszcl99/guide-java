package com.markus.desgin.mode.structural.adapter;

import static com.markus.desgin.mode.structural.adapter.AdvancedComputerSlot.TYPEC;
import static com.markus.desgin.mode.structural.adapter.ComputerSlot.HDMI;
import static com.markus.desgin.mode.structural.adapter.ComputerSlot.USB;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public class AdapterPatternDemo {
  public static void main(String[] args) {
    AdvancedComputerSlot advancedComputerSlot = new AdvancedComputerSlotImpl();
    advancedComputerSlot.typeC(TYPEC);
    advancedComputerSlot.typeC(HDMI);
    advancedComputerSlot.typeC(USB);
  }
}
