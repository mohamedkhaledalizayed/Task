package smile.khaled.mohamed.task.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import smile.khaled.mohamed.task.repository.MainRepository;
import smile.khaled.mohamed.task.repository.SubscribersRepository;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;

public class SubscribersViewModel extends ViewModel {

    private LiveData<List<Subscribers>> responseLiveData;

    public LiveData<List<Subscribers>> getSubscribersObservable(String url){
        responseLiveData =new SubscribersRepository().getSubscribers(url);
        return responseLiveData;
    }
}
