package com.example.davidgh.movies.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidgh.movies.R;
import com.example.davidgh.movies.models.SectionMovieModel;

import java.util.ArrayList;

public class RecyclerViewMoviesAdapter extends RecyclerView.Adapter<RecyclerViewMoviesAdapter.ItemRowHolder>{

    private ArrayList<SectionMovieModel> sections;
    private Context mContext;

    public RecyclerViewMoviesAdapter(Context mContext, ArrayList<SectionMovieModel> sections) {
        this.mContext = mContext;
        this.sections = sections;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);

        return new ItemRowHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, final int position) {

        String sectionName = sections.get(position).getHeader();
        ArrayList singleSectionItems = sections.get(position).getAllItems();

        holder.tvSectionTitle.setText(sectionName);
        SectionListMultAdapter adapter = new SectionListMultAdapter(mContext, singleSectionItems);

        holder.rvSectionItems.setHasFixedSize(true);
        holder.rvSectionItems.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.rvSectionItems.setAdapter(adapter);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 10: implement btnMore functionality
                Toast.makeText(mContext, "btnMore " + position + " Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != sections ? sections.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvSectionTitle;
        protected RecyclerView rvSectionItems;
        protected Button btnMore;

        public ItemRowHolder(View itemView) {
            super(itemView);

            tvSectionTitle = itemView.findViewById(R.id.tv_section_title);
            btnMore = itemView.findViewById(R.id.btn_more);
            rvSectionItems = itemView.findViewById(R.id.rv_section_items);
        }
    }
}
