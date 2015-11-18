package br.com.myapp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Itens> itensList;
    private RecyclerView mRecyclerView;
    private TextView textTotal;
    private TextView textData;
    private static final DecimalFormat formato = new DecimalFormat("#.00");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTotal = (TextView) findViewById(R.id.num_total);
        textData = (TextView) findViewById(R.id.num_data);
        Calendar dataAtual = Calendar.getInstance();
        textData.setText(dateFormat.format(dataAtual.getTime()));

        // Carrega lista de itens
        itensList = gerarListaItens();

        // RECYCLER VIEW
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        // Faz o primeiro carregamento da lista recycle view
        ItensRecycleAdapter adapter = new ItensRecycleAdapter(getApplicationContext(), itensList);
        mRecyclerView.setAdapter(adapter);
    }

    private List<Itens> gerarListaItens() {
        String[] nomes = new String[] {"Cereal","Martelo","Sabão","Luminária","Teclado","Mouse","Cadeira",
                "Mesa","Cerâmica","Monitor"};
        Double[] valores = new Double[] {2.49, 7.05, 5.10, 46.90, 113.89, 22.10, 65.00, 98.30, 230.90, 33.00};
        List<Itens> itensArrayList = new ArrayList<>();
        Double soma = 0.0;

        for (int i = 0; i < 10; i++) {
            soma += valores[i];
            Itens itens = new Itens(nomes[i], valores[i]);
            itensArrayList.add(itens);
        }
        textTotal.setText(String.valueOf(formato.format(soma)));
        return itensArrayList;
    }
}
