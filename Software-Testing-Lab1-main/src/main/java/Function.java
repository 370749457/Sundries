import lombok.Data;

@Data
public class Function {
    public final static double PI = Math.PI;

    public double abs(double x)
    {
        if (x < 0) x = -x;
        return x;
    }

    public double Factorial(int x)
    {
        if (x == 1 || x == 0) return 1;
        else
            return 1.0 * x * Factorial(x - 1);
    }


    public double nth(double x, int n)// 3th  means a*a*a
    {
        if (n > 0) {
            return x * nth(x, n - 1);
        }

        if (n < 0) {
            return (1 / x) * nth(x, n + 1);
        }

        return 1;
    }

    double Bernoulli(int x)
    {
        int k = x;
        double B = 0;
        if (x == 0)
            return 1;
        else if (x > 1 && x % 2 == 1) {
            return 0;
        } else {
            while (k > 0) {
                k --;
                B += -1.0 * (Factorial(x) * Bernoulli(k)) / (Factorial(x - k) * Factorial(k) * (x - k + 1));
            }
            return B;
        }
    }

    double tan(double x)
    {
        int i = 1;
        double EPS = 1.0e-8;
        double e = 1, sum = 0;
        while (x < (-PI / 2)) x += PI;
        while (x > (PI / 2)) x -= PI;
        if (abs(x) == (PI / 2)) {
            throw new IllegalArgumentException("num should not be this");
        }
        while (abs(e) > EPS && i <= 26)// limit i in Bernoulli to increase speed
        {
            e = (nth(-1, i - 1) * nth(2, 2 * i) * (nth(2, 2 * i) - 1.0) * Bernoulli(2 * i) * nth(x, 2 * i - 1)) / (Factorial(2 * i));
            sum += e;
            i++;
        }
        return sum;
    }


}
