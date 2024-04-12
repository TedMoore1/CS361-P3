//import java.util.Set;
//import java.util.List;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class TM {
    //7-Tuple:
    //private int alphabet;
    private LinkedHashSet<Character> tapeAlphabet;
    private TMState[] states;
    //private TMState qAccept;
    private int qAccept;
    //Not needed TMState qReject;
    //TMState startState;
    private LinkedList<Character> tape;
    
    public TM(int numStates, int numSigma){
        this.tapeAlphabet = new LinkedHashSet<>();
        this.tapeAlphabet.add('0');

        this.states = new TMState[numStates];
        //startState = new TMState(numSigma);
        //states[0] = startState;
        for (int i = 0; i < numStates; i++){
            states[i] = new TMState(numSigma);
        }
        //qAccept = new TMState(numSigma);
        //states[numStates] = qAccept;
        qAccept = numStates-1;
        tape = new LinkedList<>();
    }


    public boolean test(){
        //Integer.parseInt() is fastest

        int curr = 0;
        if (tape.size() == 0){
            tape.addFirst('0');
        }
        ListIterator<Character> itr = tape.listIterator(0);
        // if(!itr.hasNext()){
        //     itr.add('0');
        // }
        char c = itr.next();
        String lastMove = "R";
        while (curr != qAccept){
            String[] t = states[curr].getT(c-'0');
            
            curr = Integer.parseInt(t[0]);
            itr.set(t[1].charAt(0));

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

        System.out.println(tape.toString());
        System.out.println(tape.size());

        return true;
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

    
}
