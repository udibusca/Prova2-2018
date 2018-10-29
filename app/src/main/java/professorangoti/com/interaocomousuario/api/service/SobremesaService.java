package professorangoti.com.interaocomousuario.api.service;

import java.util.List;

import professorangoti.com.interaocomousuario.api.domain.ProdutoVrDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SobremesaService {


    @GET("precos")
    Call<List<ProdutoVrDto>> getPrecoSobremesa();

}
