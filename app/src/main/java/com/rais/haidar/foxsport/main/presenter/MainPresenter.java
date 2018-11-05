package com.rais.haidar.foxsport.main.presenter;

import com.rais.haidar.foxsport.Base.BasePresenter;
import com.rais.haidar.foxsport.Network.configNetwork;
import com.rais.haidar.foxsport.main.model.ArticlesItem;
import com.rais.haidar.foxsport.main.model.ResponseFoxSport;
import com.rais.haidar.foxsport.main.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String apikey = "5h30dB4K4Uwuhj4KkmHmFkrBzQHtf2wGPVQSARoCa+HgMHZRk0/vFn0ZKpFDgc1KYy/F7LEE8nAOHhKgru6btQ==";

    public Call<ResponseFoxSport> call() {
        return configNetwork.getInstance().getFox();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseFoxSport>() {
            @Override
            public void onResponse(Call<ResponseFoxSport> call, Response<ResponseFoxSport> response) {
                if (response.body().getStatus().equalsIgnoreCase("ok")){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseFoxSport> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(MainView v) { mainView = v;}

    @Override
    public void onDetach() { mainView = null;}
}
