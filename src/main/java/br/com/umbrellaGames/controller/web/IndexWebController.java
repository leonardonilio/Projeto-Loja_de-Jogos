package br.com.umbrellaGames.controller.web;

import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.service.CategoriaService;
import br.com.umbrellaGames.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexWebController {

    @Autowired
    private JogoService jogoService;

    @Autowired
    private CategoriaService categoriaService;

    // Método que vai listar os jogos no index
    @GetMapping
    public String findAll(Model model) {
        List<Jogo> jogos = jogoService.findAll();
        model.addAttribute("recomendados", jogoService.findAll());
        model.addAttribute("gratuitos", jogoService.buscarGratuitos());
        model.addAttribute("promocao", jogoService.buscarPromocao());
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("destaques", jogoService.buscarDestaques());
        return "index";
    }
}
