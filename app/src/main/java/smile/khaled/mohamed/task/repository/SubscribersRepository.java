package smile.khaled.mohamed.task.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smile.khaled.mohamed.task.service.RetrofitModule;
import smile.khaled.mohamed.task.service.ServiceApi;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;

public class SubscribersRepository {

    public static ServiceApi service= RetrofitModule.getInstance().getService();


    public LiveData<List<Subscribers>> getSubscribers(String url) {
        final MutableLiveData<List<Subscribers>> data = new MutableLiveData<>();



        service.getSubscribers(url).enqueue(new Callback<List<Subscribers>>() {
            @Override
            public void onResponse(Call<List<Subscribers>> call, Response<List<Subscribers>> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Subscribers>> call, Throwable t) {
                Log.e("Error", t.getMessage() + "");
            }
        });



        return data;
    }
}
