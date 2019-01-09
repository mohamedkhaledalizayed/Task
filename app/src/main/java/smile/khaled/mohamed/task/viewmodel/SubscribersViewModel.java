package smile.khaled.mohamed.task.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import smile.khaled.mohamed.task.repository.SubscribersRepository;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;

public class SubscribersViewModel extends ViewModel {

    private LiveData<List<Subscribers>> listLiveData;

    public LiveData<List<Subscribers>> getSubscribersObservable(String url){
        listLiveData =new SubscribersRepository().getSubscribers(url);
        return listLiveData;
    }
}
