package br.com.fiap.rotasdereciclagem.controller;

import br.com.fiap.rotasdereciclagem.dto.CaminhaoExibicaoDTO;
import br.com.fiap.rotasdereciclagem.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reciclagem")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public Page<CaminhaoExibicaoDTO> listarTodos(
            @PageableDefault(size = 15)Pageable paginacao
            ){
        return caminhaoService.listarTodos(paginacao);
    }

    @GetMapping("/caminhoes/{idCaminhao}")
    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorId(@PathVariable Long idCaminhao){
        try{
            return ResponseEntity.ok(caminhaoService.buscarPorId(idCaminhao));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorPlaca(@RequestParam String placa){
        try{
            return ResponseEntity.ok(caminhaoService.buscarPorPlaca(placa));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}