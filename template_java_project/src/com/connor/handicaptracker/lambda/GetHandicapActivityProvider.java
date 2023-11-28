package com.connor.handicaptracker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.connor.handicaptracker.activity.GetHandicapActivity;
import com.connor.handicaptracker.dependency.ServiceComponent;
import com.connor.handicaptracker.models.requests.GetHandicapRequest;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.results.GetHandicapResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;

public class GetHandicapActivityProvider {
    private static ServiceComponent serviceComponent;

    public void GetHandicapActivityProvider() {

    }

    @Override
    public GetHandicapResult handleRequest(final GetHandicapRequest getHandicapRequest, Context context) {
        return getServiceComponent().provideGetHandicapActivity().handleRequest(getHandicapRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = DaggerServiceComponent.create();
        }

        return serviceComponent;
    }
}
