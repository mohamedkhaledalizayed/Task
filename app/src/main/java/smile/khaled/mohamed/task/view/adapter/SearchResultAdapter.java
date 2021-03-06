package smile.khaled.mohamed.task.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

        import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.RepositoryItemBinding;
import smile.khaled.mohamed.task.model.Repo;
import smile.khaled.mohamed.task.service.response.search.ItemsItem;
import smile.khaled.mohamed.task.service.response.search.SearchResponse;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder>
{

    private List<ItemsItem> responseList;
    private Context context;
    private LayoutInflater layoutInflater;
    public SearchResultAdapter(Context context, List<ItemsItem> recentList) {
        this.responseList = recentList;
        this.context=context;
    }

    @Override
    public SearchResultAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RepositoryItemBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.repository_item, parent, false);

        return new SearchResultAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final SearchResultAdapter.MyViewHolder holder, final int position) {
        holder.binding.setRepo(new Repo(responseList.get(position).getName(),
                responseList.get(position).getOwner().getLogin(),
                responseList.get(position).getDescription(),
                responseList.get(position).getOwner().getAvatarUrl()));

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RepositoryItemBinding binding;
        public MyViewHolder(RepositoryItemBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }




}