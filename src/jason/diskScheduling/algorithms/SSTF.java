package jason.diskScheduling.algorithms;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class SSTF extends Algorithm {
    public SSTF(ArrayList<Integer> requests, int headStart) {
        super(requests, headStart);
    }

    @Override
    public void run() {
        int shortest;
        int closest;
        int seektime;
        int index;
        int cyl;
        int cylIndex = -1;

        while (requests.size() > 0){
            shortest = Integer.MAX_VALUE;
            closest = diskHead;
            for(index = 0; index < requests.size(); index++){
                cyl = requests.get(index);
                seektime = abs(diskHead - cyl);
                if (seektime < shortest) {
                    closest = cyl;
                    cylIndex = index;
                    shortest = seektime;
                }
            }
            totalMovement += shortest;
            diskHead = closest;
            requests.remove(cylIndex);
        }

        returnTotal("SSTF");
    }
}
