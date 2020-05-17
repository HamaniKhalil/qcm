package qcm;

import qcm.data.models.Quiz;
import qcm.utils.ArgumentCheck;

import java.io.*;

public class Corrige {

    private static final int ARGUMENTS_LENGTH = 2;

    private static BufferedReader qcmReader;
    private static BufferedReader responsesReader;

    public static void main(String[] args) {
        ArgumentCheck arguments = new ArgumentCheck(ARGUMENTS_LENGTH);
        arguments.check(args);

        final String READ_FILENAME = args[0];
        final String WRITE_FILENAME = args[1];

        try {
            qcmReader = new BufferedReader(new FileReader(READ_FILENAME));
            responsesReader = new BufferedReader(new FileReader(WRITE_FILENAME));

            Quiz quiz = new Quiz();

            quiz.lit(qcmReader);
            quiz.litCorrige(responsesReader);
            quiz.ecritCorrige();

            qcmReader.close();
            responsesReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
