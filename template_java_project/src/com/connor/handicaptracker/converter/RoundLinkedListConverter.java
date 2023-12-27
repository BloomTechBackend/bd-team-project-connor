package com.connor.handicaptracker.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.connor.handicaptracker.dao.models.Rounds;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;
import java.util.List;

public class RoundLinkedListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();
    //private final Logger log = LogManager.getLogger();

    @Override
    public String convert(List listToBeConverted) {
        return GSON.toJson(listToBeConverted);
    }

    @Override
    public List unconvert(String dynamoDbRepresentation) {
        // need to provide the type parameter of the list to convert correctly
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<LinkedList<Rounds>>() {
        }.getType());
    }
}

