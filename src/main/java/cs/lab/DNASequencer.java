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
        Boolean joined = false;

        for(int indexTemp = temp.length(); indexTemp > 0; --indexTemp) {
            common = temp.substring(0, indexTemp);

            if (result.toString().endsWith(common)) {
                joined = true;
                result.append(temp.substring(indexTemp));
                break;
            }
        }

        if (Boolean.FALSE.equals(joined)){
            result.append(temp);
        }

        return result.toString();
    }

    public String calculate(List<String> parts) throws MaxSubsequenceAmountException, SubSequenceLengthException {
        if(parts.size() > 160000) {
            throw new MaxSubsequenceAmountException("Too many subseqs");
        }

        StringBuilder result = new StringBuilder();
        String temp = "";
        String answer = "";

        for(int i = 0; i < parts.size(); ++i) {
            if(parts.get(i).length() > 200) {
                throw new SubSequenceLengthException("Subseqs is too long");
            }

            if(i == 0) {
                result.append((parts.get(0)));
            } else {
                temp = parts.get(i);
                answer = join(result, temp);
            }

        }

        return answer;
    }
}
