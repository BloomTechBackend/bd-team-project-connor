package com.connor.handicaptracker.lambda;

import com.connor.handicaptracker.dependency.DaggerServiceComponent;
import com.connor.handicaptracker.dependency.ServiceComponent;
import com.connor.handicaptracker.models.requests.AddRoundToRoundsRequest;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.results.AddRoundToRoundsResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;

//import javax.naming.Context;
import com.amazonaws.services.lambda.runtime.Context;

public class GetPlayerActivityProvider {
    private static ServiceComponent serviceComponent;

    public void GetPlayerActivityProvider() {

    }


    public GetPlayerResult handleRequest(final GetPlayerRequest getPlayerRequest, Context context) {
        return getServiceComponent().provideGetPlayerActivity().handleRequest(getPlayerRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = DaggerServiceComponent.create();
        }

        return serviceComponent;
    }
}
