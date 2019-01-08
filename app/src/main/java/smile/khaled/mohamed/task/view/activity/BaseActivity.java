package smile.khaled.mohamed.task.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.service.RetrofitModule;
import smile.khaled.mohamed.task.service.ServiceApi;

public class BaseActivity extends AppCompatActivity {

    public static ServiceApi service= RetrofitModule.getInstance().getService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
