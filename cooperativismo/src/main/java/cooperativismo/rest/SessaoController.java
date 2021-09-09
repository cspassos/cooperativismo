package cooperativismo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cooperativismo.model.entity.Sessao;
import cooperativismo.service.SessaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sessao")
@RequiredArgsConstructor//Cria um construtor com os argumentos obrigatorios
public class SessaoController {
	
	@Autowired
	private SessaoService sessaoService;
	
	@PostMapping("pauta/{idPauta}")
	@ResponseStatus(HttpStatus.CREATED)
	public Sessao criarSessao(@PathVariable Long idPauta, @RequestBody Sessao sessao) {
		return sessaoService.criarSessao(idPauta, sessao);
	}
	
	@GetMapping("{id}")
	public Sessao buscarPorId(@PathVariable Long id) {
		return sessaoService.buscarPorId(id);
	}
	
	@GetMapping
	public List<Sessao> buscarTodasSessoes() {
		return sessaoService.buscarTodasSessoes();
	}

	@DeleteMapping("{id}")
	public void excluirSessao(@PathVariable Long id) {
		sessaoService.excluirSessao(id);
	}
}
