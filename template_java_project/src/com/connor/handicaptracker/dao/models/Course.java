package com.connor.handicaptracker.dao.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "courses")
public class Course {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String course;
    private double rating;
    private int slope;

    public Course(String course, double rating, int slope) {
        this.course = course;
        this.rating = rating;
        this.slope = slope;
    }

    public Course() {

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return Double.compare(course1.rating, rating) == 0 && slope == course1.slope && Objects.equals(course, course1.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, rating, slope);
    }

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                ", rating=" + rating +
                ", slope=" + slope +
                '}';
    }
}
