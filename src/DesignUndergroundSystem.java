import java.util.HashMap;

class UndergroundSystem {
    class StationTime {
        int startTime;
        String station;

        public StationTime(int startTime, String station) {
            this.startTime = startTime;
            this.station = station;
        }
    }

    HashMap<Integer, StationTime> inTime;
    HashMap<String, double[]> averageTime;

    public UndergroundSystem() {
        inTime = new HashMap<>();
        averageTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        inTime.put(id, new StationTime(t, stationName));
    }

    public void checkOut(int id, String stationName, int t) {
        StationTime start = inTime.get(id);
        String routeName = start.station + "," + stationName;
        double[] routeStat = averageTime.getOrDefault(routeName, new double[] { 0, 0 });

        routeStat[0] += 1;
        routeStat[1] += t - start.startTime;
        averageTime.put(routeName, routeStat);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "," + endStation;
        double[] routeStat = averageTime.get(routeName);

        return routeStat[1] / routeStat[0];
    }
}
