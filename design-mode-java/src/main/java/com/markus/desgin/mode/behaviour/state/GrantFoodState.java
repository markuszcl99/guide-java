package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 8:54 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GrantFoodState implements State {
    @Override
    public void selectGoods(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }

    @Override
    public void payMoney(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }

    @Override
    public void grantGoods(VendingMachine vendingMachine) {
        System.out.println("物品已发放，您可以继续选择物品或者退出界面");
        vendingMachine.setGoodCounts(vendingMachine.getGoodCounts() - 1);
        vendingMachine.setCurrentState(vendingMachine.getSelectGoodState());
    }
}
