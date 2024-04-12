//import java.util.LinkedHashMap;
//import java.util.ArrayList;

public class TMState {
    private String[][] t;

    public TMState(int alphabet){
        t = new String[alphabet+1][3];
    }


    
    public boolean addT(int c, String toState, String write, String move){
        t[c][0] = toState;
        t[c][1] = write;
        t[c][2] = move;
        return true;
    }

    public String[] getT(int c){
        return this.t[c];
    }
}