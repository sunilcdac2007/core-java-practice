package com.interview.array;

public class GasStationCircle {
    // gasAvailable = [4,4,6]
    // gasRequired  = [5,6,1]
    public int startTour(int gasAvailable[], int[] gasRequired){
        int start = -1;
        int end = 0;
        int currentGas = 0;
        boolean visitedOnce = false;
        while(start != end){
            currentGas = currentGas + gasAvailable[end] - gasRequired[end];
            if(start == -1){
                start = end;
            }
            if(end == gasAvailable.length -1 && visitedOnce == false){
                visitedOnce = true;
            } else if(end == gasAvailable.length -1 && visitedOnce == true){
                return -1;
            }
            if(currentGas < 0){
                start = -1;
                currentGas = 0;
            }
            end = (end + 1)% gasAvailable.length;
        }
        return end;
    }

    static void main() {
        int[] gasAvailable = {4,4,6};
        int[] gasRequired  = {5,6,1};
        GasStationCircle gasStationCircle = new GasStationCircle();
        gasStationCircle.startTour(gasAvailable, gasRequired);
    }
}
