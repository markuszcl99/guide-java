package com.markus.desgin.mode.structure.adapter;

import static com.markus.desgin.mode.structure.adapter.AdvancedComputerSlot.TYPEC;
import static com.markus.desgin.mode.structure.adapter.ComputerSlot.HDMI;
import static com.markus.desgin.mode.structure.adapter.ComputerSlot.USB;

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
