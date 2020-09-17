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

    public String calculate(List<String> parts) throws Exception {
        if(parts.size() > 160000) {
            throw new MaxSubsequenceAmountException("Too many subseqs");
        }

        if(parts.get(0).length() > 200) {
            throw new SubSequenceLengthException("Subseqs is too long");
        }

        StringBuilder result = new StringBuilder();
        result.append(parts.get(0));
        String temp = "";
        String answer = "";


        for(int i = 1; i < parts.size(); ++i) {
            temp = parts.get(i);

            if(temp.length() > 200) {
                throw new SubSequenceLengthException("Subseqs is too long");
            }

            answer = join(result, temp);
        }

        return answer;
    }
}
