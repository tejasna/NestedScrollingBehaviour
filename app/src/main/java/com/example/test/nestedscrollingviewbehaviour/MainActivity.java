package com.example.test.nestedscrollingviewbehaviour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView chatRV = (RecyclerView) findViewById(R.id.chat_recycler_view);
    /**
     * A custom linear layout manager to handle wrapping of recycler view.
     * This is done for the recycler-view to not take all the space available in the scroll view
     * But rather wrap in it.
     */
    LinearLayoutManager chatLinearLayoutManager =
        new WrappingLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    chatRV.setLayoutManager(chatLinearLayoutManager);

    ArrayList<Integer> dummyData = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      dummyData.add(i);
    }

    Adapter chatRecyclerAdapter = new Adapter(dummyData);
    chatRV.setAdapter(chatRecyclerAdapter);
    chatRV.setNestedScrollingEnabled(false);

    //ViewTreeObserver.OnGlobalLayoutListener layoutListener =
    //    new ViewTreeObserver.OnGlobalLayoutListener() {
    //      @Override public void onGlobalLayout() {
    //        Rect r = new Rect();
    //        rootView.getWindowVisibleDisplayFrame(r);
    //        int screenHeight = rootView.getRootView().getRootView().getHeight();
    //        int heightDifference = screenHeight - (r.bottom - r.top);
    //
    //        if (heightDifference > screenHeight / 3) {
    ////          scrollView.fullScroll(View.FOCUS_DOWN);
    //        }
    //      }
    //    };
    //
    //rootView.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
  }
}
