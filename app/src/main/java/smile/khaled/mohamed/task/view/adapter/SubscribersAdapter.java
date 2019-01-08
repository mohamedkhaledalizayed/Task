package smile.khaled.mohamed.task.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import smile.khaled.mohamed.task.R;
import smile.khaled.mohamed.task.databinding.SubscriberItemBinding;
import smile.khaled.mohamed.task.service.response.subscriber.Subscribers;
import smile.khaled.mohamed.task.model.Subscriper;

public class SubscribersAdapter extends RecyclerView.Adapter<SubscribersAdapter.MyViewHolder>
{

    private List<Subscribers> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    public SubscribersAdapter(Context context, List<Subscribers> recentList) {
        this.recentList = recentList;
        this.context=context;
    }

    @Override
    public SubscribersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        SubscriberItemBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.subscriber_item, parent, false);

        return new SubscribersAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final SubscribersAdapter.MyViewHolder holder, final int position) {

        holder.binding.setSubscriper(new Subscriper(recentList.get(position).getLogin(),recentList.get(position).getAvatarUrl()));
    }

    @Override
    public int getItemCount() {
        return recentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public SubscriberItemBinding binding;
        public MyViewHolder(SubscriberItemBinding view) {
            super(view.getRoot());
            this.binding=view;

        }
    }
}