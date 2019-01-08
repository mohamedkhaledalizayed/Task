package smile.khaled.mohamed.task.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.ActivitySubscribersBinding;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;
import smile.khaled.mohamed.task.view.adapter.SubscribersAdapter;

import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;
import static smile.khaled.mohamed.task.data.Constants.SUBSCRIBERS_URL;

public class SubscribersActivity extends BaseActivity {

    private LinearLayoutManager mLayoutManager;
    private ActivitySubscribersBinding binding;
    private SubscribersAdapter mAdapter;
    private List<Subscribers> subscribersList = new ArrayList<>();

    private String name;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subscribers);

        name=getIntent().getStringExtra(REPO_NAME);
        url=getIntent().getStringExtra(SUBSCRIBERS_URL);
        mAdapter = new SubscribersAdapter(this, subscribersList);

        getSupportActionBar().setTitle(name);
        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);

        service.getSubscribers(url).enqueue(new Callback<List<Subscribers>>() {
            @Override
            public void onResponse(Call<List<Subscribers>> call, Response<List<Subscribers>> response) {
                subscribersList.addAll( response.body());
                getSupportActionBar().setSubtitle("Subscribers : "+ subscribersList.size());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Subscribers>> call, Throwable t) {

            }
        });
    }
}
