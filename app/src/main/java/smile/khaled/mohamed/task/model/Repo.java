package smile.khaled.mohamed.task.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class Repo {
    public String name;
    public String repoName;
    public String descreption;
    public String imageUrl;

    public Repo(String name,String repoName,String descreption,String imageUrl) {
        this.name = name;
        this.repoName = repoName;
        this.descreption = descreption;
        this.imageUrl = imageUrl;
    }




    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);



    }
}
