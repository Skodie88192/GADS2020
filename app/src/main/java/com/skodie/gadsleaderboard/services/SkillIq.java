package com.skodie.gadsleaderboard.services;

import com.skodie.gadsleaderboard.model.SkillIqLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIq {


    @GET("/api/skilliq")
    Call<List<SkillIqLeadersInfo>> getLearners();
}
