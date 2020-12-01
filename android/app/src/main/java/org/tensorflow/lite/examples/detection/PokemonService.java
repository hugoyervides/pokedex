package org.tensorflow.lite.examples.detection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("pokemon/{pokemonName}")
    Call<Pokemon> getPokemonByName(@Path("pokemonName") String pokemonName);
}
