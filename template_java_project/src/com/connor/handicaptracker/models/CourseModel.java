package com.connor.handicaptracker.models;

import com.amazonaws.internal.config.Builder;
import com.connor.handicaptracker.dao.models.Course;

import java.util.Objects;

public class CourseModel {
    private String course;

    public CourseModel() {

    }

    public CourseModel(Builder builder) {
        this.course = builder.course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseModel that = (CourseModel) o;
        return Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "course='" + course + '\'' +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String course;

        public Builder withCourse(String courseToUse) {
            this.course = courseToUse;
            return this;
        }
    }
}
