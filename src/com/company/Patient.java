package com.company;

public class Patient {
    String name;
    String address;
    int sessionNum;
    int questionNum;

    public Patient(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(int sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        double totalSession = 100.00;
        double totalQuestion = 0.35;
        double sum;

        if (getSessionNum() != 0) {
            totalSession = totalSession * getSessionNum();
        }
        if (getQuestionNum() != 0) {
            totalQuestion = totalQuestion * getQuestionNum();
        }
        sum = totalSession + totalQuestion;
        String patientInfo = new StringBuilder()
                .append("Raven's Invoice\n")
                .append("To:\n")
                .append(this.name)
                .append("\n")
                .append(this.address)
                .append("\n\n")
                .toString();
        String itemInfo = new StringBuilder()
                .append("Items:")
                .append("\nQuantity Description Price Total")
                .append("\n" + getSessionNum() + " session 100.00 " + totalSession)
                .append("\n" + getQuestionNum() + " questions .35 " + totalQuestion)
                .append("\n")
                .append("Total Due: $" + sum)
                .append("\nThank you for doing business with Raven.")
                .toString();
        return patientInfo + itemInfo;
    }
}
