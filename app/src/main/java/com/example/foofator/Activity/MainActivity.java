package com.example.foofator.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foofator.Activity.Domain.CategoryDomain;
import com.example.foofator.Adapter.CategoryAdapter;
import com.example.foofator.Adapter.PopularAdapter;
import com.example.foofator.Domain.FoodDomain;
import com.example.foofator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);

        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }




    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    public void recyclerViewPopular(){
        LinearLayoutManager linaerLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linaerLayoutManager);

        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizaa","pizza","slices_pepperoni,mozzerella cheese,fresh oregano,ground black pepper,pizza sauce",99.76));
        foodList.add(new FoodDomain("Cheese Burger","pop_2","beef,Gouda Cheese,Special Sause, Lettuce, tomoto",89.79));
        foodList.add(new FoodDomain("Vegitable Pizza","pop_1","olive oil, Vegitable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil",80.79));
        foodList.add(new FoodDomain("Vegitable Pizza","pop_3","olive oil, Vegitable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil",67.79));

        adapter2=new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}