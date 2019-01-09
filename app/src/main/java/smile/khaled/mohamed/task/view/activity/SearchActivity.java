package smile.khaled.mohamed.task.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tripl3dev.prettystates.StateExecuterKt;
import com.tripl3dev.prettystates.StatesConstants;

import java.util.ArrayList;
import java.util.List;

import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.view.Utils;
import smile.khaled.mohamed.task.databinding.ActivitySearchBinding;
import smile.khaled.mohamed.task.service.response.search.ItemsItem;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;
import smile.khaled.mohamed.task.view.adapter.SearchResultAdapter;
import smile.khaled.mohamed.task.viewmodel.SearchViewModel;

import static smile.khaled.mohamed.task.data.Constants.DONE;
import static smile.khaled.mohamed.task.data.Constants.NO_DATA;
import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;

public class SearchActivity extends BaseActivity {

    private LinearLayoutManager mLayoutManager;
    private ActivitySearchBinding binding;
    private SearchResultAdapter mAdapter;
    private List<ItemsItem> itemList = new ArrayList<>();
    private String name;
    private int pageNumber=1;
    private boolean isLoading=true;
    private int pastVisibleItem,visibleItemsCount,totalItemsCount,previousTotal=0;
    //The minimum amount of items to have below your current scroll position, before loading more
    private static final int THRESHOLD=3;
    private SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        name=getIntent().getStringExtra(REPO_NAME);
        mAdapter = new SearchResultAdapter(this, itemList);

        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);

        if (Utils.isInternetAvailable(this)){
            //this to show loading state and disappear when data return from web service
            //we can customize the view as we want and make it better than default views
            StateExecuterKt.setState(binding.recycler, StatesConstants.LOADING_STATE);
            setPagination();
        }else {
            Toast.makeText(this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
            error();
        }

        binding.recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemsCount=mLayoutManager.getChildCount();
                totalItemsCount=mLayoutManager.getItemCount();
                pastVisibleItem=mLayoutManager.findFirstVisibleItemPosition();

                if (dy>0){
                    if (isLoading){
                        if (totalItemsCount>previousTotal){
                            isLoading=false;
                            previousTotal=totalItemsCount;
                        }
                    }

                    if (!isLoading && (totalItemsCount-visibleItemsCount)<=(pastVisibleItem + THRESHOLD)){
                        pageNumber++;
                        isLoading=true;
                        setPagination();
                        }
                }
            }
        });
    }

    private void setPagination() {

        if (pageNumber != 1){
            binding.progressBar.setVisibility(View.VISIBLE);
        }
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.getSearchResultObservable(name,pageNumber).observe(this, new Observer<SearchResponse>() {
            @Override
            public void onChanged(@Nullable SearchResponse searchResponse) {
                binding.progressBar.setVisibility(View.GONE);
                if (searchResponse.getStatus() == DONE){
                    StateExecuterKt.setState(binding.recycler, StatesConstants.NORMAL_STATE);
                    itemList.addAll(searchResponse.getItems());
                    mAdapter.notifyDataSetChanged();
                }else if (searchResponse.getStatus() == NO_DATA){
                    StateExecuterKt.setState(binding.recycler, StatesConstants.EMPTY_STATE);
                }else {
                    error();
                }
            }
        });
    }

    private void error() {
        //this for error for any reason and we can click button to load data again
        View v= StateExecuterKt.setState(binding.recycler, StatesConstants.ERROR_STATE);
        Button errorBt = v.findViewById(R.id.textButton);
        errorBt.setOnClickListener((View view) -> {
            if (Utils.isInternetAvailable(SearchActivity.this)){
                setPagination();
            }else {
                Toast.makeText(this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
                error();
            }
        });
    }

}
