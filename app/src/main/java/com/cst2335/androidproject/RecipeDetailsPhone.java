package com.cst2335.androidproject;

import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewStub;
import com.cst2335.utilities.BaseNavActivity;

/**
 * When on a phone and a user wants to view recipe details this
 * is the activity that is used to display recipe details for
 * as specific recipe. It makes use of the same layout as
 * the tablet does for displaying recipe details
 * layout_fragment_recipe_details.
 */
public class RecipeDetailsPhone extends BaseNavActivity {

    /**
     * The onCreate method for this activity containing main actions to be taken when using this
     * activity.
     * @param savedInstanceState Bundle passed to this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_nav);

        // include tool bar and nav drawer, as well as inflate this activitie's layout
        setupNavigation("Chad Rocheleau", getString(R.string.recipe_details_title), "1.0");
        ViewStub stub = findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.activity_recipe_details_phone);
        stub.inflate();

        // use the recipe details fragment to display recipe details on a phone
        Bundle args = getIntent().getExtras();
        FragmentManager fm = getSupportFragmentManager();
        RecipeDetailsFragment recipeDetails = new RecipeDetailsFragment();
        recipeDetails.setArguments(args);

        fm.beginTransaction()
                .replace(R.id.recipe_details_fragment, recipeDetails)
                .commit();
    }

    /**
     * Overrides onOptionsItemSelected to provide custom functionality for the info button in the
     * toolbar when using this activity
     * @param item the item selected in the toolbar
     * @return boolean value
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(("This is the recipe details activity. It presents the " +
                    "details of the selected recipe. You may navigate to the website using the " +
                "go to website button. Using the navigation drawer you can navigate to other " +
                "activities. The recipe may be favourited or unvafourited using the bookmark icon " +
                "at the bottom of the page."))
                .setCancelable(false)
                .setPositiveButton("Okay", (dialog, id) -> {

                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
        return false;
    }
}