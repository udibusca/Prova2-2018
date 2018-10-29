package professorangoti.com.interaocomousuario.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import professorangoti.com.interaocomousuario.R;
import professorangoti.com.interaocomousuario.api.domain.ProdutoVrDto;

public class PrecoActivity extends AppCompatActivity {

    @BindView(R.id.vr_pedido)
    TextView mValorPedidoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preco);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        ProdutoVrDto produtoVrDto = null;

        if (bundle != null) {
            produtoVrDto = (ProdutoVrDto) bundle.getSerializable("pedido");
        }

        if (produtoVrDto != null) {
            mValorPedidoTextView.setText(produtoVrDto.getValor());
        }
    }
}
