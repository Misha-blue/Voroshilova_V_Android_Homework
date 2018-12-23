package ru.androidacademy.msk.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.androidacademy.msk.lists.data.Actor;

public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ViewHolder> {

    List<Actor> actorList;
    LayoutInflater inflater;
    RequestManager imageLoader;

    public ActorListAdapter(List<Actor> actorList, Context context) {
        this.actorList=actorList;
        inflater=LayoutInflater.from(context);
        imageLoader=Glide.with(context);
    }

    @NonNull
    @Override
    public ActorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.actor_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorListAdapter.ViewHolder holder, int position) {

        Actor actor=actorList.get(position);

        holder.textView.setText(actor.getName());

        holder.oscarView.setVisibility(actor.isOscar()? View.VISIBLE:View.INVISIBLE);

        imageLoader.load(actor.getAvatar()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView, oscarView;
        final TextView textView;

        ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.avatar);
            textView = (TextView) view.findViewById(R.id.name);
            oscarView = (ImageView) view.findViewById(R.id.oscar);
        }
    }
}
