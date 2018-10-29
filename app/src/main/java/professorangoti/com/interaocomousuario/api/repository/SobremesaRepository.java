package professorangoti.com.interaocomousuario.api.repository;

import android.support.annotation.NonNull;

import java.util.List;

import professorangoti.com.interaocomousuario.SobremesaApplication;
import professorangoti.com.interaocomousuario.api.APIClient;
import professorangoti.com.interaocomousuario.api.domain.ProdutoVrDto;
import professorangoti.com.interaocomousuario.api.service.ISobremesaService;
import professorangoti.com.interaocomousuario.api.service.SobremesaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SobremesaRepository implements ISobremesaService {

    private SobremesaServiceListener sobremesaServiceListener;
    private APIClient apiClient;

    public SobremesaRepository(SobremesaServiceListener sobremesaServiceListener) {
        this.sobremesaServiceListener = sobremesaServiceListener;
        this.apiClient = SobremesaApplication.getInstance().getApiClient();
    }

    @Override
    public void getPrecoSobremesa() {
        SobremesaService sobremesaService = this.apiClient.getRetrofit().create(SobremesaService.class);
        Call<List<ProdutoVrDto>> sobremesaResponse = sobremesaService.getPrecoSobremesa();

        sobremesaResponse.enqueue(new Callback<List<ProdutoVrDto>>() {
            @Override
            public void onResponse(@NonNull Call<List<ProdutoVrDto>> call, @NonNull Response<List<ProdutoVrDto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sobremesaServiceListener.response(response.body());
                } else if (response.code() == 500) {
                    sobremesaServiceListener.serverError("Não foi possivel conectar ao servidor!");
                } else if (response.code() != 200) {
                    sobremesaServiceListener.serverError("Erro desconhecido!");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProdutoVrDto>> call, @NonNull Throwable t) {
                sobremesaServiceListener.serverError("Não foi possivel conectar ao servidor!");
            }
        });
    }

    public interface SobremesaServiceListener {
        void response(List<ProdutoVrDto> produtoVrDto);

        void serverError(String message);
    }
}
