package com.rais.haidar.foxsport.Base;

public interface BasePresenter <T extends BaseView> {

    void onAttach(T v);
    void onDetach();

}
