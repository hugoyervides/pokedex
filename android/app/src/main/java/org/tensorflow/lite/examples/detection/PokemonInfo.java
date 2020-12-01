package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PokemonService pokeService = retrofit.create(PokemonService.class);

        //Get intent and the information
        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("POKEMON_NAME");

        //Update Pokemon details in view
        TextView pokemonNameTextView = findViewById(R.id.pokemonName);
        pokemonNameTextView.setText(pokemonName);
        loadPokemonDataFromService(pokeService, pokemonName);
    }

    public void loadPokemonDataFromService(PokemonService pokeService, String pokemonName){
        TextView pokemonHeight = findViewById(R.id.pokemonHeight);
        TextView pokemonWeight = findViewById(R.id.pokemonWeight);
        TextView pokemonId = findViewById(R.id.pokemonId);

        Call<Pokemon> pokeCall = pokeService.getPokemonByName(pokemonName.toLowerCase());
        pokeCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                // ANY CODE THAT DEPENDS ON THE RESULT OF THE SEARCH HAS TO GO HERE
                Pokemon foundPoke = response.body();
                // check if the body isn't null
                if (foundPoke != null) {
                    Double height = Double.parseDouble(foundPoke.getHeight()) / 10;
                    pokemonHeight.setText("Height: " + height + "m");
                    Double weight = Double.parseDouble(foundPoke.getWeight()) / 10;
                    pokemonWeight.setText("Weight: " + weight + "kg");
                    pokemonId.setText("Pokemon ID: " + foundPoke.getId());
                }
            }
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                // TOAST THE FAILURE
                Toast.makeText(PokemonInfo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}