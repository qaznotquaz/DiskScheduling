package jason.diskScheduling;

import jason.diskScheduling.algorithms.*;

import java.util.ArrayList;
import java.util.Random;

public class ScheduleTester {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage: java -jar ScheduleTester.jar <initial position>");
            return;
        }

        final int min = 0;
        final int max = 4999;
        int headStart = Integer.parseInt(args[0]);

        ArrayList <Integer> requests = new ArrayList<>();
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        for(int i = 0; i < 1000; i++){
            requests.add(r.nextInt(((max-min) + 1) + min));
        }

        Thread fcfs = new Thread(new FCFS (new ArrayList<>(requests), headStart));
        Thread sstf = new Thread(new SSTF (new ArrayList<>(requests), headStart));
        Thread scan = new Thread(new SCAN (new ArrayList<>(requests), headStart, max, min));
        Thread cscan = new Thread(new CSCAN(new ArrayList<>(requests), headStart, max, min));
        Thread look = new Thread(new LOOK (new ArrayList<>(requests), headStart));
        Thread clook= new Thread(new CLOOK(new ArrayList<>(requests), headStart));

        fcfs.start();
        sstf.start();
        scan.start();
        cscan.start();
        look.start();
        clook.start();
    }
}
