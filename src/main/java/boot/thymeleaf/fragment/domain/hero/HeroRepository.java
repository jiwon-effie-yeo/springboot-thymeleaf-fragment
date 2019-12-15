package boot.thymeleaf.fragment.domain.hero;

import boot.thymeleaf.fragment.dto.HeroFindAllResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HeroRepository extends JpaRepository<boot.thymeleaf.fragment.domain.hero.Hero, Long> {

    @Query( "select h " +
            "from Hero h " +
            "order by h.id desc")
    Page<HeroFindAllResponseDto> HeroFindAllResponse(Pageable pageable);

}
