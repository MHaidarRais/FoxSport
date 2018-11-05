package com.rais.haidar.foxsport.main.view;

import com.rais.haidar.foxsport.Base.BaseView;
import com.rais.haidar.foxsport.main.model.ArticlesItem;

import java.util.List;

public interface MainView extends BaseView {
    void onSuccess(List<ArticlesItem> data);
    void onError(String msg);
}
