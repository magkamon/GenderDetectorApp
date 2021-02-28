package detector.controller;

import detector.domain.Token;
import detector.domain.TokenProvider;
import detector.dto.TokenForm;
import detector.services.DetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("tokens")
public class AllTokensController {

    private final DetectorService detectorService;

    @Autowired
    public AllTokensController(DetectorService detectorService) {
        this.detectorService = detectorService;
    }

    @GetMapping("/choose-gender")
    public String chooseGender(Model model){
        model.addAttribute(new TokenForm());
        model.addAttribute("tokens", detectorService.getTokens());
        return "choose-gender-token";
    }

    @PostMapping("/all")
    public String getAll(@ModelAttribute("tokenForm") TokenForm tokenForm, Model model){
        Optional<TokenProvider> tokenProvider = detectorService.getProvider(tokenForm.getToken());
        if(tokenProvider.isEmpty()){
            System.out.println("HELLLLLLLO");
            return "redirect:/tokens/choose-gender";
        }
        List<String> tokens = new ArrayList<>();
        Optional<String> nextToken = tokenProvider.get().getNextToken();
        while (nextToken.isPresent()){
            tokens.add(nextToken.get());
            nextToken = tokenProvider.get().getNextToken();
        }
        model.addAttribute("genderTokens", tokens);
        return "all-tokens";
    }




}
