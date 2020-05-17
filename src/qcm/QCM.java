package qcm;

import qcm.data.models.Quiz;
import qcm.utils.ArgumentCheck;

import java.io.*;

public class QCM {

    private final static int ARGUMENTS_LENGTH = 3;

    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) {
        ArgumentCheck arguments = new ArgumentCheck(ARGUMENTS_LENGTH);
        arguments.check(args);

        final int SEED = Integer.parseInt(args[0]);
        final String READ_FILENAME = args[1];
        final String WRITE_FILENAME = args[2];

        try {
            reader = new BufferedReader(new FileReader(READ_FILENAME));
            writer = new BufferedWriter(new FileWriter(WRITE_FILENAME));

            Quiz quiz = new Quiz();

            quiz.lit(reader);
            quiz.melange(SEED);
            quiz.ecrit(writer);

            reader.close();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
