package qcm;

import qcm.data.models.Question;
import qcm.data.models.Quiz;
import qcm.utils.ArgumentCheck;

import java.io.*;

public class Interro {

    private static final int ARGUMENTS_LENGTH = 2;

    static BufferedReader reader;
    static BufferedWriter writer;


    public static void main(String[] args) {
        ArgumentCheck arguments = new ArgumentCheck(ARGUMENTS_LENGTH);
        arguments.check(args);

        final String READ_FILENAME = args[0];
        final String WRITE_FILENAME = args[1];

        try {
            reader = new BufferedReader(new FileReader(READ_FILENAME));
            writer = new BufferedWriter(new FileWriter(WRITE_FILENAME));

            Quiz quiz = new Quiz();

            quiz.lit(reader);
            quiz.melange();

            for(Question question : quiz.getQuestions()) {
                question.askUserForResponse();
            }

            quiz.ecritReponses(writer);

            reader.close();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
