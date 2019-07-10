package com.company;

import java.util.*;

public class Raven {
    private List<String> positiveWord = new ArrayList<>();
    private List<String> negativeWord = new ArrayList<>();
    private int questionCount = 0;

    public Raven() {
        Collections.addAll(positiveWord, "good", "glad", "happy", "relaxed", "accomplished", "alert", "creative");
        Collections.addAll(negativeWord, "bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid");
    }

    public void RavenAnswer(String userInput) {
        int numPosi = 0;
        int numNega = 0;
        List<String> container = new ArrayList<>();
        String[] con = userInput.split(" ");

        for (int i = 0; i < con.length; i++) {
            container.add(con[i]);
        }

        for (int i = 0; i < container.size(); i++) {
            for (int j = 0; j < this.positiveWord.size(); j++) {
                if (container.get(i).equalsIgnoreCase(this.positiveWord.get(j))) {
                    numPosi++;
                }
            }
        }
        for (int i = 0; i < container.size(); i++) {
            for (int j = 0; j < this.negativeWord.size(); j++) {
                if (container.get(i).equalsIgnoreCase(this.negativeWord.get(j))) {
                    numNega++;
                }
            }
        }
        if (numPosi == numNega) {
            System.out.println("Meh");
        }
        if (numPosi > numNega) {
            System.out.println("I am so happy for you...Yay...");
        }
        if (numPosi < numNega) {
            System.out.println("Really! Why, tell me more!");
        }
    }

    public void SetUserInfo() {
        String nameUser;
        String addressUser;
        String answerSession;
        int sessionCount = 0;
        boolean isQuitSession = false;

//        List<Patient> patientList = new ArrayList<>();


//        do {
        System.out.println("Good morning, how are you feeling today?");
        System.out.println("Please fill in your name: ");
        nameUser = new Scanner(System.in).nextLine();
        System.out.println("Please fill in your address: ");
        addressUser = new Scanner(System.in).nextLine();
        Patient patient = new Patient(nameUser, addressUser);
//            patientList.add(patient);
        while (!isQuitSession) {
            ++sessionCount;
            Session();
            System.out.println("Do you want to start another session? Press q to quit, press any key to continue.");
            answerSession = new Scanner(System.in).nextLine();
            if (answerSession.equalsIgnoreCase("q")) {
                isQuitSession = true;
            }
        }
        patient.setSessionNum(sessionCount);
        patient.setQuestionNum(this.questionCount);
        System.out.println(patient.toString());
//            System.out.println("Do you want to continue? Press q to quit, press any key to continue.");
//            answer = new Scanner(System.in).nextLine();
//        } while (!answer.equalsIgnoreCase("q"));

    }

    private void Session() {
        String answer;
        String userInput;


        do {
            System.out.println("Tell me how do you feel now?");
            userInput = new Scanner(System.in).nextLine();
            RavenAnswer(userInput);
            ++this.questionCount;
            System.out.println("Do you want to ask another question? Press q to quit, press any key to continue.");
            answer = new Scanner(System.in).nextLine();
        } while (!answer.equalsIgnoreCase("q"));

    }

    private int getQuestions(int questionNum) {
        return questionNum;
    }


}
