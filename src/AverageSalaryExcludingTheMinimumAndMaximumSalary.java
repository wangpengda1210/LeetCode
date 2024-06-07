/**
 * You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary.
 * Answers within 10-5 of the actual answer will be accepted.
 */

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        double sum = 0;
        for (int i : salary) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            sum += i;
        }

        return (sum - max - min) / (salary.length - 2);
    }
}
