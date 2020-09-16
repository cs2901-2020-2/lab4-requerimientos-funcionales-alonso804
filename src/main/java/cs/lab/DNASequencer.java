package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());

    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String join(StringBuilder result, String temp) {
        String common = "";
        for(int indexTemp = temp.length(); indexTemp > 0; --indexTemp) {
            common = temp.substring(0, indexTemp);

            if (result.toString().endsWith(common)) {
                result.append(temp.substring(indexTemp));
                break;
            }
        }

        return result.toString();
    }

    public String calculate(List<String> part){
        StringBuilder result = new StringBuilder();
        result.append(part.get(0));
        String temp = "";
        String answer = "";

        for(int i = 1; i < part.size(); ++i) {
            temp = part.get(i);
            answer = join(result, temp);
        }

        return answer;
    }
}