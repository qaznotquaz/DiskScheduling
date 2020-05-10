package jason.diskScheduling.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class LOOK extends Algorithm {
    int max;
    int min;

    public LOOK(ArrayList<Integer> requests, int headStart) {
        super(requests, headStart);
        this.max = Collections.max(requests)+1;
        this.min = Collections.min(requests)-1;
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

        returnTotal("LOOK");
    }
}
