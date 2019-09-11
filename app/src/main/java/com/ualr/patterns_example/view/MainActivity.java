package com.ualr.patterns_example.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ualr.patterns_example.R;
import com.ualr.patterns_example.viewmodel.UserViewModel;
import com.ualr.patterns_example.databinding.ActivityMainBinding;

// TODO 01.03. We have to delete the View interface since it's no longer needed.
public class MainActivity extends AppCompatActivity {

    // TODO 0: We have to avoid the tight relationship between the view and the presenter
    // TODO 01: The presenter is replaced by the viewmodel. In this case:
    //        + Only the view holds the reference to the viewmodel
    //        + The viewmodel holds only a reference to the model (no need the reference to the view, less coupling)
    // TODO 01.01: Change the naming of packages and classes related to the presenter
    // TODO 01.02: Reference to the view is no longer desirable. Remove it from the UserViewModel
    // TODO 01.03. View interface is no longer needed.
    // TODO 01.04. We no longer invoke viewmodel (the old presenter) methods directly from the view (the activity). We can delete almost al the code related to the viewmodel.
    //              We keep the declaration and the creation of a new instance.
    // TODO 01.05. We don't manage GUI events in the view. They will be manager by the viewmodel.
    //              In this case we can delete all the defined OnClickListeners
    // TODO 01.06. References to GUI elements are no longer needed
    // TODO 02: We are going to use Android data binding: less glue code to connect view and viewmodel.
    //          Data binding allows you to bind UI components to data sources in a declarative way (no programmatically).
    //          Thanks to databinding:
    //              + the viewmodel provides data streams to the view
    //              + the viewmodel uses callbacks to update the view
    // TODO 02.01. We have to enable databinding in the project.
    //              + Add dataBinding element to build.gradle file
    //              + Enable dataBinding compiler in gradle.properties file:
    // TODO 03. viewmodel must receive events from the GUI. We'll have to make some changes in our layout in order to use databiding.
    //              TODO 03.01. Use a layout element as root of the layout
    //              TODO 03.02. Define a property inside the layout that will reference our viewmodel.
    //              TODO 03.03. Create the bindings with the Binding class automatically generated for the layout
    //              TODO 03.04. We can invoke some methods right from the layout file. Awesome!
    //              TODO 03.05. We have to create bindings for the different values we want to manage from viewmodel.
    //              TODO 03.06. We have to define these values as observable in order to get their updated value anytime.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 03.03. Create the bindings with the Binding class automatically generated for the layout
        // We have to replace setContentView. We'll use the setContentView provided by DataBindingUtil
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(new UserViewModel());
    }
}
