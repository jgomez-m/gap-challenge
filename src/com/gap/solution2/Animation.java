package com.gap.solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Julian G on 3/26/2017.
 */
public class Animation {

    private static int chamberSize;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the speed an initial particles position");
        String buffer = sc.nextLine();
        int speed = Integer.parseInt(buffer.split(",")[0]);
        String initChamber = buffer.split(",")[1];
        List<String> answer = animate(speed, initChamber.trim());
        System.out.println("Chamber Steps:");
        for(String str : answer){
            System.out.println(str);
        }
    }

    /**
     * The main method. Starts the animation of particles
     * @param speed The speed of particles
     * @param init The Init particles state
     * @return The all steps of the animation
     */
    public static List<String> animate(int speed, String init){
        chamberSize = init.length();
        int time = 0;
        List<Particle> particleList = init(init, speed);
        List<String> chamber = new ArrayList<>();

        while(true){
            List<Integer> positions = calculatePositions(particleList, time);
            chamber.add(drawChamber(positions));
            if(!isChamberWithParticles(positions)){
                break;
            }
            time = time + 1;
        }
        return chamber;
    }

    /**
     *
     * @param initState
     * @param speed
     * @return
     */
    private static List<Particle> init(String initState, int speed) {
        List<Particle> particles = new ArrayList<>();
        int chamberSize = initState.length();
        for(int i = 0; i< chamberSize; i++){
            char current = initState.charAt(i);
            if(current != '.'){
                particles.add(new Particle(current, i, speed));
            }
        }
        return particles;

    }

    /**
     * This method verifies if there is one particle at least
     * @param positions List of particles positions
     * @return True if the chamber is not empty else false
     */
    private static boolean isChamberWithParticles(List<Integer> positions){
        for(Integer particlePos : positions){
            if(0 <= particlePos && particlePos < chamberSize){
                return true;
            }
        }
        return false;
    }

    /**
     * Calculate the position for a given time
     * @param particles
     * @param time
     * @return
     */
    private  static List<Integer> calculatePositions(List<Particle> particles, int time){
        List<Integer> positions = new ArrayList<>();
        for(Particle particle : particles){
            positions.add(particle.locationAfter(time));
        }
        return positions;
    }

    /**
     * Draw a state of the chamber with a given positions and ize
     * @param positions List of particle positions
     * @return A string that represents empty space and particles with 'X'
     */
    private static String drawChamber(List<Integer> positions) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chamberSize; i++) {
            if (positions.contains(i)) {
                builder.append("X");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }
}