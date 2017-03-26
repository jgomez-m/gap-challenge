package com.gap.solution2;

/**
 * Created by Julian G on 3/26/2017.
 */
public class Particle {
    private char direction;
    private int startLocation;
    private int speed;

    public Particle(char direction, int startLocation, int speed) {
        this.direction = direction;
        this.speed = speed;
        this.startLocation = startLocation;
    }

    /**
     * Calculate the new position of the particle
     * @param time
     * @return If particle position is 'R' then increase
     * if not then position decrease
     */
    public int locationAfter(int time){
        if(direction == 'R'){
            return (time * speed) + startLocation;
        }
        else {
            return startLocation - (time * speed);
        }
    }
}
