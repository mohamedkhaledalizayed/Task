package smile.khaled.mohamed.task.app;

import android.app.Application;

import smile.khaled.mohamed.task.service.RetrofitModule;


public class Task extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitModule.intialize(this);
    }
}
