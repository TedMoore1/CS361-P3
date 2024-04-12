import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;

public class TMSimulator {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Add file name");
        }
        Scanner scn = new Scanner(args[0]);

        int numStates = Integer.parseInt(scn.nextLine());
        int numSigma = Integer.parseInt(scn.nextLine());

        TM tm = new TM(numStates,numSigma);

        String[] t = new String[3];
        for (int state = 0; state < numStates; state++){
            for (int c = 0; c <= numSigma; c++){
                t = scn.nextLine().split(",");
                tm.addTransition(state,c,t[0],t[1],t[2]);
            }
        }

        String input = scn.nextLine();
        if(!input.equals("")){
            tm.addInput(input);
        }

        //test tm halt

        scn.close();
    }

}