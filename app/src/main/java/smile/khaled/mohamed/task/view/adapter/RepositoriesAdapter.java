package smile.khaled.mohamed.task.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.RepositoryItemBinding;
import smile.khaled.mohamed.task.model.Repo;
import smile.khaled.mohamed.task.service.response.repo.RepoResponse;
import smile.khaled.mohamed.task.view.IRepoHandler;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private List<RepoResponse> responseList;
    private IRepoHandler handler;
    private Context context;
    public RepositoriesAdapter(Context context, List<RepoResponse> recentList) {
        this.responseList = recentList;
        this.context=context;
        handler = (IRepoHandler) context;
    }

    @Override
    public RepositoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RepositoryItemBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.repository_item, parent, false);

        return new RepositoriesAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final RepositoriesAdapter.MyViewHolder holder, final int position) {

        holder.binding.setRepo(new Repo(responseList.get(position).getName(),
                responseList.get(position).getOwner().getLogin(),
                responseList.get(position).getDescription(),
                responseList.get(position).getOwner().getAvatarUrl()));

        holder.binding.itemId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onClick(responseList.get(position).getName(),responseList.get(position).getSubscribersUrl());
            }
        });

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RepositoryItemBinding binding;
        public MyViewHolder(RepositoryItemBinding view) {
            super(view.getRoot());
            this.binding=view;
        }
    }
}