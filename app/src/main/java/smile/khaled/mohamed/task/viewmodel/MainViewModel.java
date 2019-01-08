package smile.khaled.mohamed.task.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import smile.khaled.mohamed.task.repository.MainRepository;
import smile.khaled.mohamed.task.repository.SearchRepository;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;

public class MainViewModel extends ViewModel {

    private LiveData<List<RepoResponse>> responseLiveData;

    public LiveData<List<RepoResponse>> getrepositoriesObservable(){
        responseLiveData =new MainRepository().getRepository();
        return responseLiveData;
    }
}
