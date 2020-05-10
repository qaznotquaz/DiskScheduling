package jason.diskScheduling.algorithms;

import java.util.ArrayList;

public class CSCAN extends Algorithm{
    int max;
    int min;

    public CSCAN(ArrayList<Integer> requests, int headStart, int max, int min) {
        super(requests, headStart);
        this.max = max+1;
        this.min = min;
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

            diskHead++;
            totalMovement++;
        }

        returnTotal("CSCAN");
    }
}
