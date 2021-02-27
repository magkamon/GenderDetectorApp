package detector.controller;

import detector.dto.CheckedGender;
import detector.dto.GenderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import detector.services.DetectorService;

import javax.validation.Valid;


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
        return "check-gender-form";
    }

    @PostMapping("/submit")
    public String submitNeedRequestForm(@Valid @ModelAttribute("genderForm") GenderForm genderForm, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("nameCheckVariant", detectorService.getVariants());
            return "check-gender-form";
        } else {
            CheckedGender checkedGender = new CheckedGender();
            checkedGender.setName(genderForm.getName());
            checkedGender.setGender(detectorService.getGender(checkedGender.getName(), genderForm.getNameCheckVariant()));
            model.addAttribute(checkedGender);
        return "checked-gender-view";
        }
    }



}
