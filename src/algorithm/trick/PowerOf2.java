package algorithm.trick;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *  给出一个非负整数num, 返回的ans为 大于等于num的最小的2的整数次幂
 *  num, ans 均限定在 int范围内
 *
 * @author egbz
 * @date 2021/4/30
 */
public class PowerOf2 {

    // HashMap   tableSizeFor()
    private int resolve1(int num) {
        int n = -1 >>> Integer.numberOfLeadingZeros(num - 1);
        return n <= 0 ? 1: n + 1;

    }

    // 直接用反射
    private int resolve2(int num) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = HashMap.class.getDeclaredMethod("tableSizeFor", int.class);
        method.setAccessible(true);
        return (Integer) method.invoke(null, num);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new PowerOf2().resolve2(5));
    }
}
