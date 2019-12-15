package boot.thymeleaf.fragment.dto;

import boot.thymeleaf.fragment.domain.hero.Hero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class HeroSaveRequestDto {

    private  String name;
    private int age;
    private  String memo;

    public Hero toEntity() {
        return  Hero.builder()
                    .name(name)
                    .age(age)
                    .memo(memo)
                    .build();

    }
}

