package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 8:54 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PayMoneyState implements State {
    @Override
    public void selectGoods(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }

    @Override
    public void payMoney(VendingMachine vendingMachine) {
        System.out.println("你支付了 xx 数目的金钱，物品稍后将进行发放...");
        vendingMachine.setCurrentState(vendingMachine.getGrantGoodState());
    }

    @Override
    public void grantGoods(VendingMachine vendingMachine) {
        throw new UnsupportedOperationException("当前状态不支持该操作");
    }
}
