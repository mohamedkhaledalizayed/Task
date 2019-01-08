package smile.khaled.mohamed.task.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.ActivitySubscribersBinding;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;
import smile.khaled.mohamed.task.view.adapter.SubscribersAdapter;
import smile.khaled.mohamed.task.viewmodel.SubscribersViewModel;

import static smile.khaled.mohamed.task.data.Constants.REPO_NAME;
import static smile.khaled.mohamed.task.data.Constants.SUBSCRIBERS_URL;

public class SubscribersActivity extends BaseActivity {

    private LinearLayoutManager mLayoutManager;
    private ActivitySubscribersBinding binding;
    private SubscribersAdapter mAdapter;
    private List<Subscribers> subscribersList = new ArrayList<>();

    private String name;
    private String url;
    private SubscribersViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subscribers);

        name = getIntent().getStringExtra(REPO_NAME);
        url = getIntent().getStringExtra(SUBSCRIBERS_URL);
        mAdapter = new SubscribersAdapter(this, subscribersList);

        getSupportActionBar().setTitle(name);
        mLayoutManager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(mAdapter);


        viewModel = ViewModelProviders.of(this).get(SubscribersViewModel.class);
        viewModel.getSubscribersObservable(url).observe(this, new Observer<List<Subscribers>>() {
            @Override
            public void onChanged(@Nullable List<Subscribers> subscribers) {
                subscribersList.addAll(subscribers);
                getSupportActionBar().setSubtitle("Subscribers : " + subscribersList.size());
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
