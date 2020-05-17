package qcm.data.models;

import qcm.data.enums.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Question {

    private QuestionType type;
    private String wording;
    private List<Proposition> propositions = new ArrayList<>();

    // Constructors
    public Question() {}

    public Question(QuestionType type, String wording, List<Proposition> propositions) {
        this.type = type;
        this.wording = wording;
        this.propositions = propositions;
    }

    // Getters
    public QuestionType getType() {
        return type;
    }

    public String getWording() {
        return wording;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    // Setters
    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    // Utils
    public void shufflePropositions() {
        Collections.shuffle(propositions);
    }

    public void shufflePropositions(Random random) {
        Collections.shuffle(propositions, random);
    }
}
