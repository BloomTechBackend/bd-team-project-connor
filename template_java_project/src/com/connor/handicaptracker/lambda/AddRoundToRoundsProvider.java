package com.connor.handicaptracker.lambda;

import com.connor.handicaptracker.dependency.ServiceComponent;
import com.connor.handicaptracker.models.requests.AddRoundToRoundsRequest;
import com.connor.handicaptracker.models.results.AddRoundToRoundsResult;
import dagger.Component;

import org.checkerframework.checker.builder.qual.CalledMethods;

import javax.naming.Context;

public class AddRoundToRoundsProvider {
    //private static App app;
    private static ServiceComponent serviceComponent;

    public void AddRoundToRoundsActivityProvider() {

    }

    @Override
    public AddRoundToRoundsResult handleRequest(final AddRoundToRoundsRequest addRoundToRoundsRequest, Context context) {
        return getServiceComponent().provideAddRoundToRoundsActivity().handleRequest(addRoundToRoundsRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = DaggerServiceComponent.create();
        }

        return serviceComponent;
    }
}
