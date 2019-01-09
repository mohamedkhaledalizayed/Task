package smile.khaled.mohamed.task.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import smile.khaled.mohamed.task.service.RetrofitModule;
import smile.khaled.mohamed.task.service.ServiceApi;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import static smile.khaled.mohamed.task.data.Constants.DONE;
import static smile.khaled.mohamed.task.data.Constants.ERROR;
import static smile.khaled.mohamed.task.data.Constants.NO_DATA;

public class MainRepository {

    public static ServiceApi service= RetrofitModule.getInstance().getService();

    final MutableLiveData<List<RepoResponse>> data = new MutableLiveData<>();

    public LiveData<List<RepoResponse>> getRepository() {

        service.getRepositoryApi().enqueue(new Callback<List<RepoResponse>>() {
            @Override
            public void onResponse(Call<List<RepoResponse>> call, retrofit2.Response<List<RepoResponse>> response) {
                //this for check status of response
                //we can use Network Bounder Resource class instead of this :)
                //but i want to try this way :)
                if (response.body() != null && response.body().size() != 0) {
                    response.body().get(0).setStatus(DONE);
                    data.setValue(response.body());
                }else if(response.body().size() == 0) {
                    setStatus(NO_DATA);
                }else {
                    setStatus(ERROR);
                }
            }

            @Override
            public void onFailure(Call<List<RepoResponse>> call, Throwable t) {
                Log.e("Error", t.getMessage() + "");
                setStatus(ERROR);
            }
        });

        return data;
    }

    private void setStatus(int status){
        List<RepoResponse> resp = new ArrayList<>();
        RepoResponse response1=new RepoResponse();
        response1.setStatus(status);
        resp.add(response1);
        data.setValue(resp);
    }
}
