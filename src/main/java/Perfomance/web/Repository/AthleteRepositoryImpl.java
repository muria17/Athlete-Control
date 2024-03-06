package Perfomance.web.Repository;

import Perfomance.web.dto.AddressDto;
import Perfomance.web.dto.AthleteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class AthleteRepositoryImpl implements AthleteRepositoryCustom {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<AthleteDto> findAthletesById(Long athleteId) {
        StringBuilder query = new StringBuilder()
                .append(" SELECT ")
                .append("    at.id 			    AS athlete_id,")
                .append("    at.nome 			AS athlete_nome,")
                .append("    at.idade 			AS athlete_idade,")
                .append("    at.peso 			AS athlete_peso,")
                .append("    at.altura 			AS athlete_altura,")
                .append("    at.data_inicio 	AS athlete_data_inicio,")
                .append("    at.logradouro 	    AS logradouro,")
                .append("    at.bairro 	        AS bairro,")
                .append("    at.cep 	        AS cep,")
                .append("    at.cidade 	        AS cidade,")
                .append("    at.uf 	            AS uf,")
                .append("    at.complemento 	AS complemento,")
                .append("    at.numero 	        AS numero")
                .append(" FROM athlete at ")
                .append(" WHERE at.id = :athlete_id ");
        final MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("athlete_id", athleteId, Types.LONGNVARCHAR);

        final List<AthleteDto> athleteDtoList = namedParameterJdbcTemplate.query(query.toString(), namedParameters, (rs, row) -> {
            AthleteDto athleteDto = new AthleteDto();
            athleteDto.setId(rs.getLong("athlete_id"));
            athleteDto.setNome(rs.getString("athlete_nome"));
            athleteDto.setPeso(rs.getString("athlete_peso"));
            athleteDto.setAltura(rs.getString("athlete_altura"));
            athleteDto.setDataInicio(rs.getDate("athlete_data_inicio"));
            athleteDto.setIdade(rs.getInt("athlete_idade"));
            athleteDto.setEndereco(new AddressDto(rs.getString("logradouro"),(rs.getString("bairro")),(rs.getString("cep")),(rs.getString("cidade")),(rs.getString("uf")),(rs.getString("complemento")),(rs.getString("numero"))));
            return athleteDto;
        });
        return athleteDtoList;
    }
}
