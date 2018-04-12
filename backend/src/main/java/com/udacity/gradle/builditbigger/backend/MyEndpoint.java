package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokesserve.JokesStore;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    @ApiMethod(name = "findRandomJoke")
    public MyBean findRandomJoke() {
        MyBean responseSendJoke = new MyBean();
        JokesStore jokesStore=new JokesStore();
        responseSendJoke.setData(jokesStore.getRandomJoke());
        return responseSendJoke;
    }


}
