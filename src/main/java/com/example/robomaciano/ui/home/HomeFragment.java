package com.example.robomaciano.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.robomaciano.databinding.FragmentHomeBinding;
import com.example.robomaciano.ui.model.*;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private EditText editText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.textView2.setCursorVisible(false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = binding.inputComand;
                TextView respostaText = binding.textView2;
                String textoDigitado = editText.getText().toString();

                Marciano marciano = new Marciano();
                String resposta = marciano.responda(textoDigitado);
                editText.setText("");
                respostaText.setCursorVisible(true);
                respostaText.setText("Resposta: "+resposta);

                System.err.println(resposta);

            }
        });

//        final TextView textView = binding.textView4;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}