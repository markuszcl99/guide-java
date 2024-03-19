package com.markus.desgin.mode.structural.adapter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/11
 * @Description:
 */
public class AdvancedComputerSlotImpl implements AdvancedComputerSlot {

  ComputerAdapter adapter = new ComputerAdapter();

  @Override
  public void typeC(String type) {
    switch (type) {
      case ComputerSlot.HDMI:
      case ComputerSlot.USB:
        adapter.typeC(type);
        break;
      case TYPEC:
        System.out.println("Type-C 接口插入成功!");
        break;
      default:
        throw new UnsupportedOperationException("暂时不支持插入其他类型");
    }
  }
}
