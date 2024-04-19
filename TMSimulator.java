import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import TM.TM;

/**
 * Defines the turing machine simulator, which takes input from a file to 
 * create a turing machine and run it
 * 
 * @author tedmoore, benbrindley
 */
public class TMSimulator {
    private Scanner scn;
    private TM tm;
    private int numStates;
    private int numSigma;

    /**
     * Simulation object has a scanner and a tm in it to create and test
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public TMSimulator(String filename) throws FileNotFoundException{
        scn = new Scanner(new File(filename));
        numStates = Integer.parseInt(scn.nextLine());
        numSigma = Integer.parseInt(scn.nextLine());
        tm = new TM(numStates, numSigma);
    }

    /**
     * Adds transitions from an input file
     */
    public void addTransitions(){
        String[] t = new String[3];
        for (int state = 0; state < numStates - 1; state++){
            for (int c = 0; c <= numSigma; c++){
                t = scn.nextLine().split(",");
                tm.addTransition(state,c,t[0],t[1],t[2]);
            }
        }
    }

    /**
     * Adds the input string from a text file
     */
    public void addInput(){
        if(scn.hasNextLine()){
            tm.addInput(scn.nextLine());
        }
        scn.close();
    }

    /**
     * Runs the simulation on the created turing machine
     */
    public void runSim(){
        tm.runTM();
    }

    public String toString(){
        return tm.toString();
    }

    public static void main(String[] args){
        final long startTime = System.currentTimeMillis();

        if (args.length == 0){
            System.out.println("Add file name");
        }
        try{
        String filename = args[0];
        TMSimulator sim = new TMSimulator(filename);
        sim.addTransitions();
        sim.runSim();
        System.out.println("output:");
        System.out.println(sim.toString());

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    final long endTime = System.currentTimeMillis();

    System.out.println("Total execution time: " + (endTime - startTime)/1000.0);
    }
}