package boot.thymeleaf.fragment.service;

import boot.thymeleaf.fragment.domain.hero.Hero;
import boot.thymeleaf.fragment.domain.hero.HeroRepository;
import boot.thymeleaf.fragment.dto.HeroFindAllResponseDto;
import boot.thymeleaf.fragment.dto.HeroFindByIdResponseDto;
import boot.thymeleaf.fragment.dto.HeroSaveRequestDto;
import boot.thymeleaf.fragment.dto.HeroUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class HeroService {
    private HeroRepository heroRepository;

    public Long HeroSaveRequest(HeroSaveRequestDto dto){
        return heroRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @ReadOnlyProperty
    public Page<HeroFindAllResponseDto> HeroFindAllResponse(Pageable pageable){
        int page = pageable.getPageNumber() == 0  ? 0 : pageable.getPageNumber() -1;
        pageable = PageRequest.of(page,5);
        return heroRepository.HeroFindAllResponse(pageable);
        /*return heroRepository.findAll().stream()
                .map(HeroFindAllResponseDto::new)
                .collect(Collectors.toList());*/
    }
    @Transactional
    public boot.thymeleaf.fragment.dto.HeroFindByIdResponseDto HeroFindByIdResponse(Long id){
        Hero hero = heroRepository.findById(id).orElse(null);
        return new HeroFindByIdResponseDto(hero);
    }

    @Transactional
    public Long HeroUpdateRequest(HeroUpdateRequestDto dto){
        return heroRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void HeroDeleteByIdRequest(Long id){
        heroRepository.deleteById(id);
    }
}
