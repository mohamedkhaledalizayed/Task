package smile.khaled.mohamed.task.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Subscriper {

    public String name;
    public String imageUrl;

    public Subscriper(String name,String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }




    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);



    }
}
