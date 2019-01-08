package smile.khaled.mohamed.task.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smile.khaled.mohamed.task.service.RetrofitModule;
import smile.khaled.mohamed.task.service.ServiceApi;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;
import static smile.khaled.mohamed.task.data.Constants.PER_PAGE;

public class SearchRepository {

    public static ServiceApi service= RetrofitModule.getInstance().getService();


    public LiveData<SearchResponse> getSearchRepository(String name, int page){
        final MutableLiveData<SearchResponse> data = new MutableLiveData<>();

        service.searchRepositoryApi(name,PER_PAGE,page).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Log.e("Done",response.body()+"");
                if (response.body()!=null){
                    data.setValue(response.body());
                }else {
                    data.setValue(new SearchResponse());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e("Error",t.getMessage()+"");
            }
        });

        return data;
    }
}
