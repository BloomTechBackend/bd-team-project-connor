package com.connor.handicaptracker.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.connor.handicaptracker.dao.models.Course;
import com.connor.handicaptracker.exceptions.CourseNotFoundException;

import javax.inject.Inject;

/**
 * Accesses data for a playlist using {@link Course} to represent the model in DynamoDB.
 */
public class CourseDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a PlaylistDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    @Inject
    public CourseDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Course} corresponding to the specified id.
     *
     * @param courseId    the Course ID

     * @return the stored course, or null if none was found.
     */
    public Course getCourse(String courseId) {
        Course course = this.dynamoDbMapper.load(Course.class, courseId);

        if (course == null) {
            throw new CourseNotFoundException("Could not find course with id " + courseId);
        }

        return course;
    }

    public Course saveCourse(Course course) {
        dynamoDbMapper.save(course);
        return course;
    }
}
