package cs.lab;

import java.util.List;
import java.util.logging.Logger;
import java.util.*;

public class DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());

    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        String result = part.get(0);
        String temp = "";
        int addIndex = 0;

        for(int i = 1; i < part.size(); ++i) {
            temp = part.get(i);

            for(int j = 0; j < result.length(); ++j) {
                if(result.charAt(j) == temp.charAt(addIndex)) {
                    ++addIndex;
                    continue;
                } else {
                    addIndex = 0;
                }
            }

            for(; addIndex < temp.length(); ++addIndex) {
                result += temp.charAt(addIndex);
            }
        }
        //logger.info(result);
        return result;
    }

    /*
    public static void main(string[] args) {

    }
    */

}
