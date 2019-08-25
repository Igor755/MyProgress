package com.project.myprogress.modelclass;

public class ProgressModel {

    private String name_progress;
    private String balls_progress;

    public ProgressModel() {
    }

    public ProgressModel(String name_progress, String balls_progress) {
        this.name_progress = name_progress;
        this.balls_progress = balls_progress;
    }

    public String getBalls_progress() {
        return balls_progress;
    }

    public void setBalls_progress(String balls_progress) {
        this.balls_progress = balls_progress;
    }

    public String getName_progress() {
        return name_progress;
    }

    public void setName_progress(String name_progress) {
        this.name_progress = name_progress;
    }

    @Override
    public String toString() {
        return "ProgressModel{" +
                "name_progress='" + name_progress + '\'' +
                '}';
    }
}
