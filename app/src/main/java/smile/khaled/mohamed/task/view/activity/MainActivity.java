package smile.khaled.mohamed.task.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tripl3dev.prettystates.StateExecuterKt;
import com.tripl3dev.prettystates.StatesConstants;
import java.util.ArrayList;
import java.util.List;
import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.view.Utils;
import smile.khaled.mohamed.task.databinding.ActivityMainBinding;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.view.IRepoHandler;
import smile.khaled.mohamed.task.view.adapter.RepositoriesAdapter;
import smile.khaled.mohamed.task.viewmodel.MainViewModel;
import static smile.khaled.mohamed.task.data.Constants.DONE;
import static smile.khaled.mohamed.task.data.Constants.NO_DATA;
import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;
import static smile.khaled.mohamed.task.data.Constants.SUBSCRIBERS_URL;

public class MainActivity extends BaseActivity implements IRepoHandler {


    private LinearLayoutManager mLayoutManager;
    private ActivityMainBinding binding;
    private RepositoriesAdapter mAdapter;
    private List<RepoResponse> repoResponseList = new ArrayList<>();
    private SearchView searchView;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new RepositoriesAdapter(this, repoResponseList);
        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);

        loadRepositories();
    }

    private void loadRepositories() {

        if (Utils.isInternetAvailable(this)){
            //this to show loading state and disappear when data return from web service
            //we can customize the view as we want and make it better than default views
            StateExecuterKt.setState(binding.recycler, StatesConstants.LOADING_STATE);

            viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            viewModel.getrepositoriesObservable().observe(this, new Observer<List<RepoResponse>>() {
                @Override
                public void onChanged(@Nullable List<RepoResponse> repoResponses) {
                    if (repoResponses.get(0).getStatus() == DONE){
                        //disappear the progress
                        StateExecuterKt.setState(binding.recycler, StatesConstants.NORMAL_STATE);
                        repoResponseList.addAll(repoResponses);
                        mAdapter.notifyDataSetChanged();
                    }else if (repoResponses.get(0).getStatus() == NO_DATA){
                        StateExecuterKt.setState(binding.recycler, StatesConstants.EMPTY_STATE);
                    }else {
                        error();
                    }
                }
            });
        }else {
            Toast.makeText(this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
            error();
        }
    }

    private void error(){
        //this for error for any reason and we can click button to load data again
        View v= StateExecuterKt.setState(binding.recycler, StatesConstants.ERROR_STATE);
        Button errorBt = v.findViewById(R.id.textButton);
        errorBt.setOnClickListener((View view) -> {
            loadRepositories();
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                intent.putExtra(REPO_NAME,query.trim());
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onClick(String name, String url) {
        Intent intent = new Intent(MainActivity.this,SubscribersActivity.class);
        intent.putExtra(REPO_NAME,name);
        intent.putExtra(SUBSCRIBERS_URL,url);
        startActivity(intent);
    }
}