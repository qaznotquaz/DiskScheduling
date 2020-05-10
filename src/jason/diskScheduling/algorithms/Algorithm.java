package jason.diskScheduling.algorithms;

import java.util.ArrayList;

public abstract class Algorithm implements Runnable {
    ArrayList<Integer> requests;
    int totalMovement;
    int diskHead;

    Algorithm(ArrayList<Integer> requests, int headStart){
        this.requests = requests;
        this.diskHead = headStart;
        this.totalMovement = 0;
    }

    public void returnTotal(String algName){
        System.out.printf("%s completed with a final score of %d.\n", algName, totalMovement);
    }
}
