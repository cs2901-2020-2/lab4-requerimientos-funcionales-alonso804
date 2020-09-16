package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());

    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String join(String result, String temp) {
        for(int indexTemp = temp.length(); indexTemp > 0; --indexTemp) {
            String common = temp.substring(0, indexTemp);

            if (result.endsWith(common)) {
                result += temp.substring(indexTemp);
                break;
            }
        }

        return result;
    }

    public String calculate(List<String> part){
        String result = part.get(0);
        String temp = "";

        for(int i = 1; i < part.size(); ++i) {
            temp = part.get(i);
            result = join(result, temp);
        }

        return result;
    }
}