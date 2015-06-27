package com.geekfamilyprojects.materialnavigation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekfamilyprojects.materialnavigation.R;
import com.geekfamilyprojects.materialnavigation.misc.IViewHolderClickListener;
import com.geekfamilyprojects.materialnavigation.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * An adapter that allows display of {@link Category} data.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    public static final String DRAWABLE = "drawable";
    private static final String ICON_CATEGORY = "icon_category_";
    private List<Category> mCategories = new ArrayList<Category>();
    private final Context context;
    private final IViewHolderClickListener mClickListener;

    public GridAdapter(Context context, IViewHolderClickListener clickListener) {
        super();
        this.context = context;
        mClickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_grid_cell, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(v, mClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Category category = mCategories.get(i);
        viewHolder.title.setText(category.getTitle());
        viewHolder.icon.setImageResource(category.getIcon());
        viewHolder.index = i;
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void addCategory(Category category){
        mCategories.add(category);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private IViewHolderClickListener mClickListener;
        public int index;
        public ImageView icon;
        public TextView title;

        public ViewHolder(View itemView, IViewHolderClickListener clickListener) {
            super(itemView);
            this.mClickListener = clickListener;
            this.icon = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            this.title = (TextView)itemView.findViewById(R.id.grid_cell_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null!=mClickListener) {
                        mClickListener.gridItemClick(mCategories.get(index));
                    }
                }
            });
        }
    }
}
