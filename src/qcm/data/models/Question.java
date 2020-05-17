package qcm.data.models;

import qcm.data.enums.QuestionType;

import java.util.*;

public class Question {

    private static final String MULTIPLE_WORDING = "(reponses multiples)";
    private static final String UNIQUE_WORDING = "(reponse unique)";
    private static final String MULTIPLE_RESPONSE = "Separer les reponses par des virgules \",\" : ";
    private static final String UNIQUE_RESPONSE = "Une seule reponse est admise : ";

    private QuestionType type;
    private String wording;
    private List<Integer> userResponses = new ArrayList<>();
    private List<Proposition> propositions = new ArrayList<>();

    // Constructors
    public Question() {
    }

    public Question(
            QuestionType type,
            String wording,
            List<Integer> userResponses,
            List<Proposition> propositions
    ) {
        this.type = type;
        this.wording = wording;
        this.userResponses = userResponses;
        this.propositions = propositions;
    }


    // Getters
    public QuestionType getType() {
        return type;
    }

    public String getWording() {
        return wording;
    }

    public List<Integer> getUserResponses() {
        return userResponses;
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

    public void setUserResponses(List<Integer> userResponses) {
        this.userResponses = userResponses;
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

    // UI
    public void askUserForResponse() {
        showQuestion();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        unstringifyUserResponses(line);
    }

    public String stringifyUserResponses() {
        StringBuilder result = new StringBuilder();
        if(!userResponses.isEmpty()) {
            int last = userResponses.size() - 1;
            for (int i = 0; i < last; i++) {
                result.append(userResponses.get(i))
                        .append(",");
            }
            result.append(userResponses.get(last));
        }
        return result.toString();
    }

    public void unstringifyUserResponses(String line) {
        if(!line.isEmpty()) {
            String[] responses = line.split(",");
            for (String response : responses) {
                userResponses.add(Integer.parseInt(response));
            }
        }
    }

    private void showQuestion() {
        System.out.print(wording + " ");
        switch (type) {
            case M:
                System.out.println(MULTIPLE_WORDING);
                break;
            case Q:
                System.out.println(UNIQUE_WORDING);
                break;
        }

        for (int i = 0; i < propositions.size(); i++) {
            System.out.println((i + 1) + ": " + propositions.get(i).getWording());
        }

        switch (type) {
            case M:
                System.out.print(MULTIPLE_RESPONSE);
                break;
            case Q:
                System.out.print(UNIQUE_RESPONSE);
                break;
        }

    }

}
