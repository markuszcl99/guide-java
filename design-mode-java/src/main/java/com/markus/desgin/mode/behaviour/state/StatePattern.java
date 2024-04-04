package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 9:00 PM
 * @Description: 状态模式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StatePattern {
    public static void main(String[] args) {
        // 建造一个售货机
        VendingMachine vendingMachine = new VendingMachine(5);
        // 选择一个物品
        State state = new SelectGoodState();
        state.selectGoods(vendingMachine);

        // 付钱
        state = new PayMoneyState();
        state.payMoney(vendingMachine);

        // 拿货
        state = new GrantFoodState();
        state.grantGoods(vendingMachine);

        // 售卖机当前货品剩余数量
        System.out.println(vendingMachine.getGoodCounts());
    }
}
