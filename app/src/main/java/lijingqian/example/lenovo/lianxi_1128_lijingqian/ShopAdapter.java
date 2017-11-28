package lijingqian.example.lenovo.lianxi_1128_lijingqian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/11/28.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.IViewHolder> {

    private Context context;
    private List<String> list;

    public ShopAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建一个view
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        return new IViewHolder(view);
    }
    @Override
    public void onBindViewHolder(IViewHolder holder, final int position) {
        //绑定视图显示数据
        //显示图片
        Glide.with(context).load(list.get(position)).into(holder.itemImageview);


        //图片的点击事件
        holder.itemImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onClick(view,position);
                }
            }
        });
        holder.itemImageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.longClick(view,position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class IViewHolder extends  RecyclerView.ViewHolder {
        @BindView(R.id.item_imageview)
        ImageView itemImageview;

       IViewHolder(View view) {
           super(view);
           ButterKnife.bind(this, view);
        }
    }



//接口回调
    private Listener listener;
    public void setlistener( Listener listener){
        this.listener=listener;
    }
    interface Listener{
        //点击事件
        public void onClick(View view, int position);
        //长按事件
        public  void longClick(View view, int position);



    }
}
