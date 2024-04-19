package TM;

/**
 * This class defines a turing machine object with a 2d array of transitions
 * 
 * @author tedmoore, benbrindley
 */
public class TMState {
    private String[][] transitions;

    /**
     * Constructor for a Turing Machine state with a 2D array of transitions
     * 
     * @param alphabet is the number of input symbols
     */
    public TMState(int alphabet){
        transitions = new String[alphabet+1][3];
    }

    /**
     * Adds a transition to a state where the read character corresponds to 
     * the row of the 2D array, and each row has a 'to State, a write symbol,
     * and a direction to move (R or L).
     * 
     * @param c
     * @param toState
     * @param write
     * @param move
     * @return
     */    
    public boolean addT(int c, String toState, String write, String move){
        transitions[c][0] = toState;
        transitions[c][1] = write;
        transitions[c][2] = move;
        return true;
    }

    /**
     * Returns the row in the transition array 
     * 
     * @param c
     * @return
     */
    public String[] getTransition(int c){
        return this.transitions[c];
    }
}