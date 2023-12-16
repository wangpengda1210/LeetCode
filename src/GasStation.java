public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPoint = 0;
        int length = gas.length;

        while (startPoint < length) {
            int currPos = startPoint;
            int currGas = gas[startPoint];
            boolean solutionFound = true;

            for (int i = 1; i <= length; i++) {
                currGas -= cost[currPos % length];
                currPos++;

                if (currGas < 0) {
                    solutionFound = false;
                    break;
                }

                currGas += gas[currPos % length];
            }

            if (solutionFound) {
                return startPoint;
            }

            startPoint = currPos;
        }

        return -1;
    }
}
