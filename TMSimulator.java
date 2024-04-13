import java.io.File;
import java.util.Scanner;

import TM.TM;

/**
 * 
 * 
 * @author
 */
public class TMSimulator {


    public static void main(String[] args){
        final long startTime = System.currentTimeMillis();

        if (args.length == 0){
            System.out.println("Add file name");
        }

        try{

        //File file = new File(args[0]);
        File file = new File("file5.txt");
        Scanner scn = new Scanner(file);


        int numStates = Integer.parseInt(scn.nextLine());
        int numSigma = Integer.parseInt(scn.nextLine());

        TM tm = new TM(numStates,numSigma);

        String[] t = new String[3];
        for (int state = 0; state < numStates - 1; state++){
            for (int c = 0; c <= numSigma; c++){
                t = scn.nextLine().split(",");
                tm.addTransition(state,c,t[0],t[1],t[2]);
            }
        }

        if(scn.hasNextLine()){
            tm.addInput(scn.nextLine());
        }

        tm.runTM();
        System.out.println("output:");
        System.out.println(tm.toString());

        scn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    final long endTime = System.currentTimeMillis();

    System.out.println("Total execution time: " + (endTime - startTime)/1000.0);
    }
}