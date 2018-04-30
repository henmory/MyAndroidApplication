package com.henmory.rxjava_retrofit.test4;

import java.util.List;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class Movie {

    private String title;
    private List<Subjects> subjects;
    public String getTitle() {
        return title;
    }
    public List<Subjects> getSubjects() {
        return subjects;
    }

    public static class Subjects {
        private String title, year, id;
        public Subjects(String title, String year, String id) {
            this.title = title;
            this.year = year;
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public String getYear() {
            return year;
        }
        public String getId() {
            return id;
        }
    }
}

