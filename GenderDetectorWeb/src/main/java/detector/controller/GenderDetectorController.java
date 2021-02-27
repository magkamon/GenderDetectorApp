package detector.controller;

import detector.dto.GenderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import detector.services.DetectorService;

@Controller
@RequestMapping("gender")
public class GenderDetectorController {

    private final DetectorService detectorService;

    @Autowired
    public GenderDetectorController(DetectorService detectorService) {
        this.detectorService = detectorService;
    }

    @GetMapping("/check")
    public String showGenderDetector(Model model){
        model.addAttribute(new GenderForm());
        model.addAttribute("nameCheckVariant", detectorService.getVariants());

        return "OK";
    }




}
