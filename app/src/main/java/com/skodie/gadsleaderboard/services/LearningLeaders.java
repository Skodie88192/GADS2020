package com.skodie.gadsleaderboard.services;

import com.skodie.gadsleaderboard.model.LearningLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeaders {


    @GET("/api/hours")
    Call<List<LearningLeadersInfo>> getLearners();
}
