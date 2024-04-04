package com.markus.desgin.mode.behaviour.state;

/**
 * @author: markus
 * @date: 2024/4/4 8:36 PM
 * @Description: 自动售货机
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class VendingMachine {
    /**
     * 自动售货机的使用流程：
     * 1. 先将货品存放到售货机里面
     * 2. 选择货品
     * 3. 支付
     * 4. 弹出货品
     */

    private final State selectGoodState;
    private final State payMoneyState;
    private final State grantGoodState;

    private int goodCounts;

    private State currentState;

    public VendingMachine(int goodCounts) {
        this.selectGoodState = new SelectGoodState();
        this.payMoneyState = new PayMoneyState();
        this.grantGoodState = new GrantFoodState();
        this.goodCounts = goodCounts;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getSelectGoodState() {
        return selectGoodState;
    }

    public State getPayMoneyState() {
        return payMoneyState;
    }

    public State getGrantGoodState() {
        return grantGoodState;
    }

    public int getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(int goodCounts) {
        this.goodCounts = goodCounts;
    }
}
