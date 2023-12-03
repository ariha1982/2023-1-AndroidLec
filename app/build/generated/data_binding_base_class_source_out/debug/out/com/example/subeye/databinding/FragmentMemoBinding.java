// Generated by view binder compiler. Do not edit!
package com.example.subeye.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.subeye.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMemoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ExtendedFloatingActionButton addMemoBtn;

  @NonNull
  public final TextView memoDesc;

  @NonNull
  public final RecyclerView memoRecyclerView;

  @NonNull
  public final LinearLayout memoTexts;

  @NonNull
  public final TextView memoTitle;

  private FragmentMemoBinding(@NonNull RelativeLayout rootView,
      @NonNull ExtendedFloatingActionButton addMemoBtn, @NonNull TextView memoDesc,
      @NonNull RecyclerView memoRecyclerView, @NonNull LinearLayout memoTexts,
      @NonNull TextView memoTitle) {
    this.rootView = rootView;
    this.addMemoBtn = addMemoBtn;
    this.memoDesc = memoDesc;
    this.memoRecyclerView = memoRecyclerView;
    this.memoTexts = memoTexts;
    this.memoTitle = memoTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMemoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_memo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMemoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addMemoBtn;
      ExtendedFloatingActionButton addMemoBtn = ViewBindings.findChildViewById(rootView, id);
      if (addMemoBtn == null) {
        break missingId;
      }

      id = R.id.memo_desc;
      TextView memoDesc = ViewBindings.findChildViewById(rootView, id);
      if (memoDesc == null) {
        break missingId;
      }

      id = R.id.memo_recyclerView;
      RecyclerView memoRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (memoRecyclerView == null) {
        break missingId;
      }

      id = R.id.memo_texts;
      LinearLayout memoTexts = ViewBindings.findChildViewById(rootView, id);
      if (memoTexts == null) {
        break missingId;
      }

      id = R.id.memo_title;
      TextView memoTitle = ViewBindings.findChildViewById(rootView, id);
      if (memoTitle == null) {
        break missingId;
      }

      return new FragmentMemoBinding((RelativeLayout) rootView, addMemoBtn, memoDesc,
          memoRecyclerView, memoTexts, memoTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}