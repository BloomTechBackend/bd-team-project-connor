package com.connor.handicaptracker.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.connor.handicaptracker.dependency.DaggerServiceComponent;
import com.connor.handicaptracker.dependency.ServiceComponent;
import com.connor.handicaptracker.models.requests.CreatePlayerRequest;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.requests.UpdatePlayerRequest;
import com.connor.handicaptracker.models.results.CreatePlayerResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;
import com.connor.handicaptracker.models.results.UpdatePlayerResult;

public class UpdatePlayerActivityProvider {
    private static ServiceComponent serviceComponent;

    public void UpdatePlayerActivityProvider() {

    }


    public UpdatePlayerResult handleRequest(final UpdatePlayerRequest UpdatePlayerRequest, Context context) {
        return getServiceComponent().provideUpdatePlayerActivity().handleRequest(UpdatePlayerRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = DaggerServiceComponent.create();
        }

        return serviceComponent;
    }
}
