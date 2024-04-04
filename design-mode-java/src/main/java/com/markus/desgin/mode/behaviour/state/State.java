package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 8:37 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface State {
    /**
     * 选择物品
     * @param vendingMachine
     */
    void selectGoods(VendingMachine vendingMachine);

    /**
     * 支付金钱
     * @param vendingMachine
     */
    void payMoney(VendingMachine vendingMachine);

    /**
     * 发放物品
     * @param vendingMachine
     */
    void grantGoods(VendingMachine vendingMachine);
}
