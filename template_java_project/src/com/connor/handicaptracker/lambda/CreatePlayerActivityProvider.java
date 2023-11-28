package com.connor.handicaptracker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.connor.handicaptracker.dependency.ServiceComponent;
import com.connor.handicaptracker.models.requests.CreatePlayerRequest;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.results.CreatePlayerResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;

public class CreatePlayerActivityProvider {
    private static ServiceComponent serviceComponent;

    public void CreatePlayerActivityProvider() {

    }

    @Override
    public CreatePlayerResult handleRequest(final CreatePlayerRequest createPlayerRequest, Context context) {
        return getServiceComponent().provideCreatePlayerActivity().handleRequest(createPlayerRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = DaggerServiceComponent.create();
        }

        return serviceComponent;
    }
}
