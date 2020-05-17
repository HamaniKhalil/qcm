package qcm.data.models;

import qcm.data.enums.PropositionType;

import static qcm.constants.Prefixes.*;

public class Proposition {

    private PropositionType type;
    private String wording;

    // Constructors
    public Proposition() {}

    public Proposition(PropositionType type, String wording) {
        this.type = type;
        this.wording = wording;
    }

    // Getters
    public PropositionType getType() {
        return type;
    }

    public String getWording() {
        return wording;
    }

    // Setters
    public void setType(PropositionType type) {
        this.type = type;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    // Utils
    public String parseProposition() {
        String result = "";

        switch (type) {
            case R:
                result += PREFIX_R;
                break;
            case V:
                result += PREFIX_V;
                break;
            case F:
                result += PREFIX_F;
                break;
        }

        result += " " + wording;

        return result;
    }
}
