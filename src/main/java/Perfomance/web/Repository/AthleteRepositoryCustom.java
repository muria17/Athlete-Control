package Perfomance.web.Repository;

import Perfomance.web.dto.AthleteDto;

import java.util.List;

public interface AthleteRepositoryCustom {
    List<AthleteDto> findAthletesById(Long athleteId);

}
