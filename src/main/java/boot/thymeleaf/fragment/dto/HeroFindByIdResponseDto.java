package boot.thymeleaf.fragment.dto;

import boot.thymeleaf.fragment.domain.hero.Hero;
import lombok.Getter;

@Getter
public class HeroFindByIdResponseDto {

    private Long id;
    private String name;
    private int age;
    private String memo;

    public HeroFindByIdResponseDto(Hero entity){
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        memo = entity.getMemo();
    }
}
