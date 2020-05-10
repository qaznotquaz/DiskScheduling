package jason.diskScheduling.algorithms;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class FCFS extends Algorithm {
    public FCFS(ArrayList<Integer> requests, int headStart) {
        super(requests, headStart);
    }

    @Override
    public void run() {
        for(int req:requests){
            totalMovement += abs(diskHead - req);
            diskHead = req;
        }

        returnTotal("FCFS");
    }
}
