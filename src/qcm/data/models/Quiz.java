package qcm.data.models;

import qcm.data.enums.PropositionType;
import qcm.data.enums.QuestionType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static qcm.constants.Prefixes.*;

public class Quiz {

    private static Question currentQuestion;

    private String title;
    private List<Question> questions = new ArrayList<>();

    // Constructors
    public Quiz() {}

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // Methods
    public void lit(BufferedReader r) throws IOException {
        String line;
        while((line = r.readLine()) != null) {
            readParser(line);
        }
    }

    public void ecrit(BufferedWriter w) throws IOException {
        for(Question question : questions) {
            w.write(writeParser(question));
        }
    }

    public void melange(int seed) {
        Random random = new Random(seed);
        Collections.shuffle(questions, random);
        for(Question question : questions) {
            question.shufflePropositions(random);
        }
    }

    public void melange() {
        Collections.shuffle(questions);
        for(Question question : questions) {
            question.shufflePropositions();
        }
    }

    // Utils
    private void readParser(String line) {
        line = line.trim();

        final String PREFIX = line.substring(0, 2);
        final String CONTENT = line.substring(2).trim();

        switch (PREFIX) {
        case PREFIX_T:
            if(title == null) {
                title = CONTENT;
            }
            break;
        case PREFIX_Q:
            currentQuestion = new Question();
            currentQuestion.setType(QuestionType.Q);
            currentQuestion.setWording(CONTENT);
            questions.add(currentQuestion);
            break;
        case PREFIX_M:
            currentQuestion = new Question();
            currentQuestion.setType(QuestionType.M);
            currentQuestion.setWording(CONTENT);
            questions.add(currentQuestion);
            break;
        case PREFIX_R:
            currentQuestion.getPropositions()
                    .add(
                            new Proposition(
                                    PropositionType.R,
                                    CONTENT
                            )
                    );
            break;
        case PREFIX_V:
            currentQuestion.getPropositions()
                    .add(
                            new Proposition(
                                    PropositionType.V,
                                    CONTENT
                            )
                    );
            break;
        case PREFIX_F:
            currentQuestion.getPropositions()
                    .add(
                            new Proposition(
                                    PropositionType.F,
                                    CONTENT
                            )
                    );
            break;
        }
    }

    private String writeParser(Question question) {
        StringBuilder result = new StringBuilder();

        switch (question.getType()) {
            case M:
                result.append(PREFIX_M);
                break;
            case Q:
                result.append(PREFIX_Q);
                break;
        }

        result.append(" ")
                .append(question.getWording())
                .append("\n");

        for(Proposition proposition : question.getPropositions()) {
            result.append(proposition.parseProposition())
                    .append("\n");
        }

        return result.toString();
    }
}
