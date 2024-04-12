//import java.util.Set;
//import java.util.List;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class TM {
    //7-Tuple:
    private int alphabet;
    private LinkedHashSet<Character> tapeAlphabet;
    private TMState[] states;
    private TMState qAccept;
    //Not needed TMState qReject;
    TMState startState;
    private LinkedList<Character> tape;
    
    public TM(int numStates, int numSigma){
        this.tapeAlphabet = new LinkedHashSet<>();
        this.tapeAlphabet.add('0');

        alphabet = numSigma;
        this.states = new TMState[numStates];

        tape = new LinkedList<>();
    }

    // public boolean accepts(LinkedList<Character> input){

    //     return false;
    // }

    public boolean addTransition(int state, int c, String toState, String write, String direction){
        return states[state].addTransition(c,toState,write,direction);
    }

    public void addInput(String input){
        for (int i = 0; i < input.length(); i++){
            tape.add(input.charAt(i));
        }
    }
}
