package com.example.robomaciano.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.robomaciano.databinding.FragmentDashboardBinding;
import com.example.robomaciano.ui.model.Marciano;
import com.example.robomaciano.ui.model.MarcianoAvancado;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Spinner spinner = binding.spinner;

        final String[] opSelect = new String[1];

        // Crie uma lista de opções para o Spinner
        List<String> opcoes = new ArrayList<>();
        opcoes.add("some");
        opcoes.add("subtraia");
        opcoes.add("multiplique");
        opcoes.add("divida");

        // Use requireContext() ou getContext() para obter o contexto do Fragmento
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, opcoes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtém a opção selecionada
                String opcaoSelecionada = (String) parent.getItemAtPosition(position);
                opSelect[0] = opcaoSelecionada;

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método chamado quando nada é selecionado
            }
        });

        binding.buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = binding.valor1;
                EditText editText2 = binding.valor2;
                TextView respostaText = binding.resposta;
                String txtValor1 = editText1.getText().toString();
                String txtValor2 = editText2.getText().toString();

                MarcianoAvancado marciano = new MarcianoAvancado();

                String resp = marciano.responda(opSelect[0], Double.parseDouble(txtValor1), Double.parseDouble(txtValor2));
                respostaText.setText("Resposta: "+resp);
                System.out.println("Resposta: "+resp);
            }
        });

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}