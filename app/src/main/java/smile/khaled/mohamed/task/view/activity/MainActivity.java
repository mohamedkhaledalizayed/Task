package smile.khaled.mohamed.task.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.ActivityMainBinding;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.view.IRepoHandler;
import smile.khaled.mohamed.task.view.adapter.RepositoriesAdapter;

import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;
import static smile.khaled.mohamed.task.data.Constants.SUBSCRIBERS_URL;

public class MainActivity extends BaseActivity implements IRepoHandler {


    private LinearLayoutManager mLayoutManager;
    private ActivityMainBinding binding;
    private RepositoriesAdapter mAdapter;
    private List<RepoResponse> repoResponseList = new ArrayList<>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new RepositoriesAdapter(this, repoResponseList);
        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);


    service.getRepositoryApi().enqueue(new Callback<List<RepoResponse>>() {
        @Override
        public void onResponse(Call<List<RepoResponse>> call, retrofit2.Response<List<RepoResponse>> response) {
            Log.e("Done",response.body()+"");
            repoResponseList.addAll(response.body());
            mAdapter.notifyDataSetChanged();

        }

        @Override
        public void onFailure(Call<List<RepoResponse>> call, Throwable t) {
            Log.e("Error",t.getMessage()+"");
        }
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
        Toast.makeText(this,url,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,SubscribersActivity.class);
        intent.putExtra(REPO_NAME,name);
        intent.putExtra(SUBSCRIBERS_URL,url);
        startActivity(intent);
    }
}
