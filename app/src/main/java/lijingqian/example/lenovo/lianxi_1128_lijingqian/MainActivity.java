package lijingqian.example.lenovo.lianxi_1128_lijingqian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private SpringView springView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        springView= (SpringView) findViewById(R.id.springview);

        //加载的图片
        list.add("https://m.360buyimg.com/n12/jfs/t6415/63/1109161893/87985/21230f90/594a3a12N9b39b232.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t8284/363/1326459580/71585/6d3e8013/59b857f2N6ca75622.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t5863/302/8961270302/97126/41feade1/5981c81cNc1b1fbef.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t7210/232/3738666823/232298/9004583e/59c3a9a7N8de42e15.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t6415/63/1109161893/87985/21230f90/594a3a12N9b39b232.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t7210/232/3738666823/232298/9004583e/59c3a9a7N8de42e15.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t7210/232/3738666823/232298/9004583e/59c3a9a7N8de42e15.jpg!q70.jpg");
        list.add("https://m.360buyimg.com/n12/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg");

        //adapter
        ShopAdapter adapter=new ShopAdapter(this,list);
        recyclerView.setAdapter(adapter);

        adapter.setlistener(new ShopAdapter.Listener() {
            //点击事件
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
            //长按事件
            @Override
            public void longClick(View view, int position) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

        //上啦加载下拉刷新

        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //下拉
                springView.onFinishFreshAndLoad();
            }
            @Override
            public void onLoadmore() {
                springView.onFinishFreshAndLoad();
            }
        });

        adapter.notifyDataSetChanged();

        //布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
