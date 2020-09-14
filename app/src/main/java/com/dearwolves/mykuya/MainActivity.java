package com.dearwolves.mykuya;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dearwolves.mykuya.adapter.ItemAdapter;
import com.dearwolves.mykuya.adapter.NewAdapter;
import com.dearwolves.mykuya.model.Service;
import com.dearwolves.mykuya.model.WhatsNew;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView featured;
    private RecyclerView products;
    private RecyclerView whatsNew;
    private ImageView showAll;
    private boolean isOpen = false;

    private List<Service> featuredItems;
    private List<Service> services;
    private List<WhatsNew> newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        featured = findViewById(R.id.featured_rv);
        products = findViewById(R.id.products_rv);
        whatsNew = findViewById(R.id.new_rv);
        showAll = findViewById(R.id.show_all);

        setFeatured();
        setNewList();
        setServices();

        showAll.setOnClickListener(view -> {
                updateHeight(products);
        });

        products.setLayoutManager(new GridLayoutManager(this, 3));
        ItemAdapter itemAdapter2 = new ItemAdapter(this, services);
        products.setAdapter(itemAdapter2);

        products.setNestedScrollingEnabled(false);


        featured.setLayoutManager(new GridLayoutManager(this, 3));
        ItemAdapter itemAdapter = new ItemAdapter(this, featuredItems);
        featured.setAdapter(itemAdapter);


        ViewGroup.LayoutParams params = products.getLayoutParams();
        params.height = 800;
        products.setLayoutParams(params);

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        whatsNew.setLayoutManager(horizontalLayoutManager);

        NewAdapter newAdapter = new NewAdapter(this, newList);
        whatsNew.setAdapter(newAdapter);

    }


    public void updateHeight(final View viewToIncreaseHeight) {
        ValueAnimator anim;
        if(isOpen) {
            anim = ValueAnimator.ofInt(270, 800);
            showAll.setImageResource(R.drawable.ic_down);
        } else {
            anim = ValueAnimator.ofInt(800, 2700);
            showAll.setImageResource(R.drawable.ic_up);
        }
        anim.addUpdateListener(valueAnimator -> {
            int val = (Integer) valueAnimator.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = viewToIncreaseHeight.getLayoutParams();
            layoutParams.height = val;
            viewToIncreaseHeight.setLayoutParams(layoutParams);
        });
        anim.setDuration(1000);
        anim.start();

        isOpen =! isOpen;
    }

    private void setFeatured() {
        featuredItems = new ArrayList<>();

        Service cleaning = new Service();
        cleaning.setImage(R.drawable.cleaning);
        cleaning.setTitle("Cleaning");

        Service shopping = new Service();
        shopping.setImage(R.drawable.shopping);
        shopping.setTitle("Shopping");

        Service massage = new Service();
        massage.setImage(R.drawable.massage);
        massage.setTitle("Massage");

        featuredItems.add(cleaning);
        featuredItems.add(shopping);
        featuredItems.add(massage);



    }

    private void setServices() {
        services = new ArrayList<>();

        Service cleaning = new Service();
        cleaning.setImage(R.drawable.cleaning);
        cleaning.setTitle("Cleaning");
        services.add(cleaning);

        Service event = new Service();
        event.setImage(R.drawable.event_assistant);
        event.setTitle("Event Assistant");
        services.add(event);

        Service office = new Service();
        office.setImage(R.drawable.office_assistant);
        office.setTitle("Office Assistant");
        services.add(office);

        Service coffee = new Service();
        coffee.setImage(R.drawable.coffee_delivery);
        coffee.setTitle("Coffee Delivery");
        services.add(coffee);

        Service food = new Service();
        food.setImage(R.drawable.food_delivery);
        food.setTitle("Food Delivery");
        services.add(food);

        Service shopping = new Service();
        shopping.setImage(R.drawable.shopping);
        shopping.setTitle("Shopping");
        services.add(shopping);

        Service grocery = new Service();
        grocery.setImage(R.drawable.grocery_delivery);
        grocery.setTitle("Grocery Delivery");
        services.add(grocery);

        Service messenger = new Service();
        messenger.setImage(R.drawable.messenger);
        messenger.setTitle("Messenger");
        services.add(messenger);

        Service bills = new Service();
        bills.setImage(R.drawable.bills_payment);
        bills.setTitle("Bills Payment");
        services.add(bills);

        Service personal = new Service();
        personal.setImage(R.drawable.personal_assistant);
        personal.setTitle("Personal Assistant");
        services.add(personal);

        Service assistant = new Service();
        assistant.setImage(R.drawable.assistant_on_bike);
        assistant.setTitle("Assistant on Bike");
        services.add(assistant);

        Service queuing = new Service();
        queuing.setImage(R.drawable.queuing_up);
        queuing.setTitle("Queuing Up");
        services.add(queuing);

        Service pet = new Service();
        pet.setImage(R.drawable.pet_sitting);
        pet.setTitle("Pet Sitting");
        services.add(pet);

        Service fly = new Service();
        fly.setImage(R.drawable.flyering);
        fly.setTitle("Flyering");
        services.add(fly);

        Service dish = new Service();
        dish.setImage(R.drawable.dish_washing);
        dish.setTitle("Dish Washing");
        services.add(dish);

        Service cash = new Service();
        cash.setImage(R.drawable.cash_delivery);
        cash.setTitle("Cash on Delivery");
        services.add(cash);

        Service massage = new Service();
        massage.setImage(R.drawable.massage);
        massage.setTitle("Massage");
        services.add(massage);

        Service deep = new Service();
        deep.setImage(R.drawable.deep_clean);
        deep.setTitle("Deep Clean");
        services.add(deep);

        Service car = new Service();
        car.setImage(R.drawable.car_wash);
        car.setTitle("Car Wash");
        services.add(car);

        Service manicure = new Service();
        manicure.setImage(R.drawable.manicure);
        manicure.setTitle("Manicure");
        services.add(manicure);

    }

    private void setNewList() {
        newList = new ArrayList<>();

        WhatsNew howTo = new WhatsNew();
        howTo.setImage(R.drawable.how_to);
        howTo.setTitle("How to Use the App");
        howTo.setDescription("Getting access to on-dema...");

        WhatsNew serv = new WhatsNew();
        serv.setImage(R.drawable.services);
        serv.setTitle("List Your Service on MyKuya");
        serv.setDescription("Do you Offer Manpower");

        newList.add(howTo);
        newList.add(serv);

    }
}