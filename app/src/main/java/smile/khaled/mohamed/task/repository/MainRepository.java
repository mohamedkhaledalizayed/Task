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
import smile.khaled.mohamed.task.service.response.search.SearchResponse;

import static smile.khaled.mohamed.task.data.Constants.PER_PAGE;

public class MainRepository {

    public static ServiceApi service= RetrofitModule.getInstance().getService();


    public LiveData<List<RepoResponse>> getRepository() {
        final MutableLiveData<List<RepoResponse>> data = new MutableLiveData<>();


        service.getRepositoryApi().enqueue(new Callback<List<RepoResponse>>() {
            @Override
            public void onResponse(Call<List<RepoResponse>> call, retrofit2.Response<List<RepoResponse>> response) {
                Log.e("Done", response.body() + "");
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<RepoResponse>> call, Throwable t) {
                Log.e("Error", t.getMessage() + "");
            }
        });

        return data;
    }
}
