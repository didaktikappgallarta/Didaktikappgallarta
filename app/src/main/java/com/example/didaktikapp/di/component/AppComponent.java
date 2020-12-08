package com.example.didaktikapp.di.component;

import com.example.didaktikapp.di.modules.AppModule;
import com.example.didaktikapp.di.modules.DataSourceModule;
import com.example.didaktikapp.features.FullscreenActivity;
import com.example.didaktikapp.features.gameover.GameOverActivity;
import com.example.didaktikapp.features.gameplay.GamePlayActivity;
import com.example.didaktikapp.features.mainmenu.MainMenuActivity;


/**
 * Created by abdularis on 18/07/17.
 */

@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class})
public interface AppComponent {

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(GameOverActivity activity);

    void inject(FullscreenActivity activity);

    void inject(GameHistoryActivity activity);

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(GameOverActivity activity);

    void inject(FullscreenActivity activity);

    void inject(GameHistoryActivity activity);
}
