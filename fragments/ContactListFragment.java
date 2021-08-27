package codeyard.contacts.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import codeyard.contacts.R;
import codeyard.contacts.adapters.ContactAdapter;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.interfaces.ItemClickListener;
import codeyard.contacts.viewmodels.ContactListViewModel;

@EFragment(R.layout.fragment_contact_list)
public class ContactListFragment extends Fragment implements ItemClickListener {

    boolean isFetched;
    boolean hasToRefresh;
    public final int errorMessageDuration = 5000;

    @ViewById
    RecyclerView recyclerView;

    ContactAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @ViewById
    CoordinatorLayout recyclerViewContainer;

    @Bean
    ContactListViewModel contactListViewModel;

    @ViewById
    LottieAnimationView loading;

    @AfterViews
    void init() {
        recyclerViewContainer.setPadding(0,getStatusBarHeight(requireContext()), 0, 0);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ContactAdapter(requireContext(), new ArrayList<>(), this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        observeContacts();
        observeError();
        if (!isFetched) {
            contactListViewModel.fetchContacts();
            isFetched = true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(hasToRefresh) {
            contactListViewModel.fetchContacts();
            hasToRefresh = false;
            loading.cancelAnimation();
            loading.setAnimation(R.raw.loading);
            loading.playAnimation();
        }
    }

    @Override
    public void onItemClick(Contact contact) {
        if (getActivity() != null) {
            NavDirections action =
                    ContactListFragment_Directions.actionContactListFragmentToContactDetailsFragment(contact);
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
        }
    }

    public void observeContacts() {
        contactListViewModel.getContacts().observe(this, contacts -> {
            adapter.update(contacts);
            hideLoading();
        });
    }

    public void observeError() {
        contactListViewModel.getError().observe(this, throwable -> {
            loading.cancelAnimation();
            hasToRefresh = true;
            loading.setAnimation(R.raw.loading_error);
            loading.playAnimation();
            String msg = getContext().getString(R.string.errorMsg, throwable.getLocalizedMessage());
            Snackbar snackbar = Snackbar.make(recyclerViewContainer, msg, errorMessageDuration);
            snackbar.show();
        });
    }

    public int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return resources.getDimensionPixelSize(resourceId);
        else
            return (int) Math.ceil((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? 24 : 25) * resources.getDisplayMetrics().density);
    }

    public void hideLoading() {
        loading.cancelAnimation();
        loading.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
