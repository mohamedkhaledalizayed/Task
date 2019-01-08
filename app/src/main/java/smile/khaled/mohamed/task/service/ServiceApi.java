package smile.khaled.mohamed.task.service;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;

public interface ServiceApi {

    @GET("repositories")
    Call<List<RepoResponse>> getRepositoryApi();


    @GET("search/repositories")
    Call<List<SearchResponse>> searchRepositoryApi(@Query("q") String name);

    @GET
    Call<List<Subscribers>> getSubscribers(@Url String url);
}
