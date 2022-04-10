import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {
    final double EPS = 1.0e-4;
    final double PI = Math.PI;
    private final Function cal = new Function();

    // 设定这个单元测试的名称
    @DisplayName("Test for function")
    // 进行参数化测试
    @ParameterizedTest
    // 参数源（将会一个个输入方法进行测试）
    @ValueSource(doubles = {-3, -2, -1, 0, 1, 2, 3, PI, PI / 3, PI / 4})
    public void check_arccos(double x) {
        // actual是实际的结果
        double actual = cal.tan(x);
        // expected是期望的结果，直接调用
        double except = Math.tan(x);
        // 断言，判断两者的差值是否小于EPS，正确则通过，否则测试失败
        Assertions.assertEquals(actual, except, EPS);
    }

    @DisplayName("Test for exception")
    @ParameterizedTest
    @ValueSource(doubles = {PI / 2, (-1) * PI / 2, 3 * PI / 2})
    public void checkIllegalArguments(double x) {
        // 断言，判断是否抛出异常
        assertThrows(IllegalArgumentException.class, () -> {
            cal.tan(x);
        });
    }

}
