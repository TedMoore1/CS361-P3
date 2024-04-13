package TM;
import java.util.LinkedList;
import java.util.ListIterator;

public class TM {
    //7-Tuple:
    private TMState[] states;
    private int qAccept;;
    private LinkedList<Character> tape;
    
    /**
     * Constructor for a Turing Machine, 
     * @param numStates
     * @param numSigma
     */
    public TM(int numStates, int numSigma){
        //this.alphabet = numSigma;
        this.states = new TMState[numStates];
        for (int i = 0; i < numStates; i++){
            states[i] = new TMState(numSigma);
        }
        qAccept = numStates-1;
        tape = new LinkedList<>();
    }


    /**
     * Simulates the Turing Machine 
     * 
     * @return
     */
    public void runTM(){
        //If input string is empty, then the tape will be empty, so initialize with a 0 (blank)
        if (tape.size() == 0){
            tape.addFirst('0');
        }
        ListIterator<Character> itr = tape.listIterator(0);

        //The character being read from the location of the head
        char c = itr.next();
        //The current state
        int curr = 0;
        //Keeps track of the last move that was made
        String lastMove = "R";

        while (curr != qAccept){
            //Gets the transition of the current state based on the character read from the tape
            String[] t = states[curr].getTransition(c-'0');
            
            //Sets current state to the next state from the transition array
            curr = Integer.parseInt(t[0]);
            //Writes the symbol from the transition array
            itr.set(t[1].charAt(0));

            //Moves next or previous depending on the move direction being right(R) or left(L) 
            if (t[2].equals("R")){
                if (lastMove.equals("L")){
                    itr.next();
                }
                if (!itr.hasNext()){
                    itr.add('0');
                    itr.previous();
                }
                c = itr.next();
                lastMove = "R";
            } else {
                if (lastMove.equals("R")){
                    itr.previous();
                }
                if (!itr.hasPrevious()){
                    itr.add('0');
                }
                c = itr.previous();
                lastMove = "L";
            }
        }
    }

    /**
     * Calculates the sum of all symbols on the tape
     * 
     * @return
     */
    private int sum(){
        ListIterator<Character> itr = tape.listIterator(0);
        int sum = 0;
        while (itr.hasNext()){
            sum += (itr.next()-'0');
        }
        return sum;
    }

    /**
     * Adds the input string to the tape linked list
     * 
     * @param input
     */
    public void addInput(String input){   
        for (int i = 0; i < input.length(); i++){
            tape.add(input.charAt(i));
        }
    }

    /**
     * Adds a transition for a state
     * 
     * @param state
     * @param c
     * @param toState
     * @param write
     * @param direction
     * @return
     */
    public boolean addTransition(int state, int c, String toState, String write, String move){
        return states[state].addT(c,toState,write,move);
    }


    /**
     * Makes a string with the output of the TM's tape, the length, and the sum of its symbols
     * 
     * @return String
     */
    public String toString(){
        String str = tape.toString();
        str = str.substring(1,str.length()-1);
        str = str.replace(", ","");
        StringBuilder retVal = new StringBuilder(str);

        retVal.append("\noutput length: " + tape.size());
        retVal.append("\nsum of symbols: " + sum());
        return retVal.toString();
    }
    
}
