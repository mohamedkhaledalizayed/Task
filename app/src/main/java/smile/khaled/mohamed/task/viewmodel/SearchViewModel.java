package smile.khaled.mohamed.task.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import smile.khaled.mohamed.task.repository.SearchRepository;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;

public class SearchViewModel extends ViewModel {

    private LiveData<SearchResponse> responseLiveData;

    public LiveData<SearchResponse> getSearchResultObservable(String name, int page){
        responseLiveData =new SearchRepository().getSearchRepository(name,page);
        return responseLiveData;
    }
}
