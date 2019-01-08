package smile.khaled.mohamed.task.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.ActivitySearchBinding;
import smile.khaled.mohamed.task.service.response.search.ItemsItem;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;
import smile.khaled.mohamed.task.view.adapter.SearchResultAdapter;

import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;

public class SearchActivity extends BaseActivity {

    private LinearLayoutManager mLayoutManager;
    private ActivitySearchBinding binding;
    private SearchResultAdapter mAdapter;
    private List<ItemsItem> responseList = new ArrayList<>();
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        name=getIntent().getStringExtra(REPO_NAME);
        mAdapter = new SearchResultAdapter(this, responseList);

        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);



        service.searchRepositoryApi(name).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Log.e("Done",response.body()+"");

                responseList.addAll(response.body().getItems());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e("Error",t.getMessage()+"");
            }
        });

    }
}
