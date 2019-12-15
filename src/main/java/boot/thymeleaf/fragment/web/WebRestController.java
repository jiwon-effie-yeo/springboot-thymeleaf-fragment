package boot.thymeleaf.fragment.web;

import boot.thymeleaf.fragment.dto.HeroFindByIdResponseDto;
import boot.thymeleaf.fragment.dto.HeroSaveRequestDto;
import boot.thymeleaf.fragment.dto.HeroUpdateRequestDto;
import boot.thymeleaf.fragment.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private HeroService heroService;

    @PostMapping("/save")
    public Long HeroSaveRequest(@RequestBody HeroSaveRequestDto dto){
        System.out.println("Hello World" + dto.getMemo());
        return heroService.HeroSaveRequest(dto);
    }

    @PostMapping("/find")
    public HeroFindByIdResponseDto HeroFindByResponse(@RequestBody Long id){
        return heroService.HeroFindByIdResponse(id);
    }

    @PutMapping("/update")
    public Long HeroUpdateRequest(@RequestBody HeroUpdateRequestDto dto){
        return heroService.HeroUpdateRequest(dto);
    }

    @DeleteMapping("/delete")
    public Long HeroDeleteByIdRequest(@RequestBody Long id){
        heroService.HeroDeleteByIdRequest(id);
        return id;
    }

}
