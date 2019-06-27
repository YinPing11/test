package com.example.demo.Entity;

public class Participant {
    private int participant_id;
    private String participant_name;
    private String game_production;
    private String participant_picture;
    private int poll;

    public int getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(int participant_id) {
        this.participant_id = participant_id;
    }

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getGame_production() {
        return game_production;
    }
    public void setGame_production(String game_production) {
        this.game_production = game_production;
    }

    public String getParticipant_picture() {
        return participant_picture;
    }

    public void setParticipant_picture(String participant_picture) {
        this.participant_picture = participant_picture;
    }

    public int getPoll() {
        return poll;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }
}
