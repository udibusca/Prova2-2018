package professorangoti.com.interaocomousuario;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import professorangoti.com.interaocomousuario.api.APIClient;

public class SobremesaApplication extends Application {

    private static SobremesaApplication sobremesaApplication;
    private APIClient apiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        sobremesaApplication = this;
        setApiClient();
    }

    private void setApiClient() {
        apiClient = new APIClient("http://provaddm2018.atwebpages.com/");
    }

    public synchronized static SobremesaApplication getInstance() {
        return sobremesaApplication;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public APIClient getApiClient() {
        return apiClient;
    }

}
