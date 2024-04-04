package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 8:53 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SelectGoodState implements State {
    @Override
    public void selectGoods(VendingMachine vendingMachine) {
        if (vendingMachine.getGoodCounts() <= 0) {
            throw new UnsupportedOperationException("当前售货机没有物品，不支持选择物品");
        }
        System.out.println("你通过自动售货机选择了xx物品");
        vendingMachine.setCurrentState(vendingMachine.getPayMoneyState());
    }

    @Override
    public void payMoney(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }

    @Override
    public void grantGoods(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }
}
