package jason.diskScheduling.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class CLOOK extends Algorithm {
    int max;
    int min;

    public CLOOK(ArrayList<Integer> requests, int headStart) {
        super(requests, headStart);
        this.max = Collections.max(requests)+1;
        this.min = Collections.min(requests)-1;
    }

    @Override
    public void run() {
        int servicing;
        while (requests.size() > 0){
            diskHead = diskHead==max ? min:diskHead;

            servicing = requests.indexOf(diskHead);
            while (servicing >= 0){
                requests.remove(servicing);
                servicing = requests.indexOf(diskHead);
            }

            diskHead ++;
            totalMovement++;
        }

        returnTotal("CLOOK");
    }
}
