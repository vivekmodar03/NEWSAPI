package com.firsapplication.newsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<Article> articles;
    private static final String TAG = "NewsAdapter";

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());

        Glide.with(context).load(article.getUrlToImage()).into(holder.imageView);

        // Set Click Listener to open article URL
        holder.itemView.setOnClickListener(v -> {
            String url = article.getUrl();
            Log.d(TAG, "onClick: Opening URL - " + url);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        });

//        holder.itemView.setAlpha(0f);
//        holder.itemView.animate().alpha(1f).setDuration(500).setStartDelay(position * 100L).start();

        // Load animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation);
        holder.itemView.startAnimation(animation);

    }

    @Override
    public int getItemCount() {
        return articles.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.textDescription);
            imageView = itemView.findViewById(R.id.imageNews);
        }
    }
}

//Step 5: Creating RecyclerView Adapter
//        A RecyclerView Adapter is required to display the news articles.

//        Created NewsAdapter.java

// This binds the API data to the RecyclerView.