package com.markus.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorType;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author: markus
 * @date: 2024/11/29 21:44
 * @Description: 运算符
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class OperatorDemo {
    public
    static void main(String[] args) throws IOException {
        // shell 脚本目录路径
        String packagePath = AviatorConstants.USER_DIR + File.separator + AviatorConstants.PACKAGE_PATH + File.separator;
        // 获取 aviator 全局实例
        AviatorEvaluatorInstance evaluatorInstance = AviatorEvaluator.getInstance();
        // 1. 幂运算
        System.out.println("################ 1. 幂运算 ################");
        Expression expression = evaluatorInstance.compileScript(packagePath + "/operator/pow.av");
        Object execute = expression.execute();
        // 2. 位运算
        System.out.println("################ 2. 位运算 ################");
        expression = evaluatorInstance.compileScript(packagePath + "/operator/bit.av");
        expression.execute();
        // 3. 运算符优先级
        // 参考文档： https://www.yuque.com/boyan-avfmj/aviatorscript/ydllav
        // 4. 运算符别名
        evaluatorInstance.aliasOperator(OperatorType.AND, "and");
        evaluatorInstance.aliasOperator(OperatorType.OR, "or");
        System.out.println(evaluatorInstance.compile("1 == 1 and 2 == 3"));
        System.out.println(evaluatorInstance.compile(" true or false"));
        System.out.println(evaluatorInstance.compile("true && 1 == 1 or false"));
        // 5. 重载运算符
        // 例如想让 整数的除结果返回为浮点数
        evaluatorInstance.addOpFunction(OperatorType.DIV, new AbstractFunction() {

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
                if (arg1.getAviatorType() == AviatorType.Long && arg2.getAviatorType() == AviatorType.Long) {
                    // 如果两个类型都是 long 类型，将两个类型进行强转
                    double d = FunctionUtils.getNumberValue(arg1, env).longValue() / FunctionUtils.getNumberValue(arg2, env).doubleValue();
                    return AviatorDouble.valueOf(d);
                } else {
                    return arg1.div(arg2, env);
                }
            }

            @Override
            public String getName() {
                return OperatorType.DIV.getToken();
            }
        });
        System.out.println(AviatorEvaluator.execute("1/2"));
    }
}
