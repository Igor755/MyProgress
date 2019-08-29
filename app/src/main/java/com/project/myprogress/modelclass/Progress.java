package com.project.myprogress.modelclass;

public class Progress {

    private String name_progress;
    private String balls_progress;

    public Progress() {
    }

    public Progress(String name_progress, String balls_progress) {
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
        return "Progress{" +
                "name_progress='" + name_progress + '\'' +
                '}';
    }
}
