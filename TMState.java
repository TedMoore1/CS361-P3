//import java.util.LinkedHashMap;
//import java.util.ArrayList;

public class TMState {
    private String[][] t;

    public TMState(String name, int alphabet){
        t = new String[alphabet+1][3];
    }


    
    public boolean addTransition(int c, String toState, String write, String direction){
        t[c][0] = toState;
        t[c][1] = write;
        t[c][2] = direction;
        return true;
    }
}