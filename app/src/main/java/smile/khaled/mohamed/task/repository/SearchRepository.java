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

import static smile.khaled.mohamed.task.data.Constants.DONE;
import static smile.khaled.mohamed.task.data.Constants.ERROR;
import static smile.khaled.mohamed.task.data.Constants.NO_DATA;
import static smile.khaled.mohamed.task.data.Constants.PER_PAGE;

public class SearchRepository {

    public static ServiceApi service= RetrofitModule.getInstance().getService();
    final MutableLiveData<SearchResponse> data = new MutableLiveData<>();


    public LiveData<SearchResponse> getSearchRepository(String name, int page){

        service.searchRepositoryApi(name,PER_PAGE,page).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.body()!=null && response.body().getItems().size() != 0){
                    response.body().setStatus(DONE);
                    data.setValue(response.body());
                }else if (response.body().getItems().size() == 0){
                    setStatus(NO_DATA);
                }
                else {
                    setStatus(ERROR);
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e("Error",t.getMessage()+"");
                setStatus(ERROR);
            }
        });

        return data;
    }

    private void setStatus(int status) {
        SearchResponse searchResponse=new SearchResponse();
        searchResponse.setStatus(status);
        data.setValue(searchResponse);
    }
}
