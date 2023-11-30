package com.connor.handicaptracker.dependency;
import com.connor.handicaptracker.activity.*;
import dagger.Component;
import javax.inject.Singleton;


@Component(modules = {DaoModule.class})
@Singleton
public interface ServiceComponent {
    CreatePlayerActivity provideCreatePlayerActivity();
    GetPlayerActivity provideGetPlayerActivity();
    UpdatePlayerActivity provideUpdatePlayerActivity();
    AddRoundToRoundsActivity provideAddRoundToRoundsActivity();
    GetHandicapActivity provideGetHandicapActivity();
}