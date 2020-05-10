package jason.diskScheduling.algorithms;

import java.util.ArrayList;

public class SCAN extends Algorithm {
    int max;
    int min;

    public SCAN(ArrayList<Integer> requests, int headStart, int max, int min) {
        super(requests, headStart);
        this.max = max;
        this.min = min;
    }

    @Override
    public void run() {
        boolean direction = true; // true is up, false is down
        int servicing;
        while (requests.size() > 0){
            if(direction){
                direction = diskHead != max;
            } else {
                direction = diskHead == min;
            }

            servicing = requests.indexOf(diskHead);
            while (servicing >= 0){
                requests.remove(servicing);
                servicing = requests.indexOf(diskHead);
            }

            diskHead += direction ? 1:-1;
            totalMovement++;
        }

        returnTotal("SCAN");
    }
}
