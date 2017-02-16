package com.example.test.nestedscrollingviewbehaviour;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

public class LisnEditText extends AppCompatEditText {
  private List<onSelectionChangedListener> listeners = new ArrayList<>();

  public LisnEditText(Context context) {
    super(context);
    listeners = new ArrayList<onSelectionChangedListener>();
  }

  public LisnEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    listeners = new ArrayList<onSelectionChangedListener>();
  }

  public LisnEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    listeners = new ArrayList<onSelectionChangedListener>();
  }

  @Override protected void onSelectionChanged(int selStart, int selEnd) {
    if(listeners != null && listeners.size() > 0) {
      for (onSelectionChangedListener listener : listeners) {
        listener.onSelectionChanged(selStart, selEnd);
      }
    }
  }

  public void addOnSelectionChangedListener(onSelectionChangedListener o) {
    listeners.add(o);
  }

  public interface onSelectionChangedListener {
    public void onSelectionChanged(int selStart, int selEnd);
  }
}
