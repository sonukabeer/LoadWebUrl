package com.sonukumariit8.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.sonukumariit8.implicitintent.databinding.FragmentFirstBinding;

import java.net.HttpURLConnection;
import java.net.URL;

public class FirstFragment extends Fragment {
    Button button;
    EditText url;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        button=view.findViewById(R.id.button);
        url=view.findViewById(R.id.url);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText=url.getText().toString();
                Toast.makeText(getActivity(), urlText, Toast.LENGTH_SHORT).show();
               // Implicit Intent to open web page

                Uri webpage = Uri.parse(urlText);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }

                // Implicit Intent to open email sending app

              //  String []addresses={"kabeer@kumar.com","anonymous@kul.com"};
               // Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                // intent.putExtra(Intent.EXTRA_EMAIL, addresses);
               // intent.putExtra(Intent.EXTRA_SUBJECT, "kabeers subject");
               // intent.putExtra(Intent.EXTRA_TEXT,urlText);
               // if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                 //   startActivity(intent);
               // }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}