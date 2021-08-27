package codeyard.contacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import codeyard.contacts.R;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.interfaces.ItemClickListener;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Contact> contacts;
    private ItemClickListener itemClickListener;

    public ContactAdapter(@NonNull Context context, List<Contact> contacts, ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        ((ContactViewHolder) holder).bind(contact, itemClickListener);
    }

    public void update(List<Contact> contactList) {
        contacts = contactList;
        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private final TextView address;
        private final ImageView image;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);
            image = itemView.findViewById(R.id.image);
        }

        public void bind(Contact contact, ItemClickListener itemClickListener){
            name.setText(contact.getName().getFullName());
            email.setText(contact.getEmail());
            address.setText(contact.getLocation().getFullAddress());
            Glide.with(image.getContext())
                    .load(contact.getPicture().getLarge())
                    .placeholder(R.drawable.image_loading)
                    .fallback(R.drawable.image_loading)
                    .into(image);
            itemView.setOnClickListener(view -> {
                try {
                    itemClickListener.onItemClick(contact);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
