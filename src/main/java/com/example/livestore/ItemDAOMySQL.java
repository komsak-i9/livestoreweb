package com.example.livestore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemDAOMySQL implements ItemDAO {

    @Autowired
    DataSource dataSource;
 
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public int insert(ItemDTO itemDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("type", itemDTO.getType());
        param.addValue("price", itemDTO.getPrice());
        param.addValue("cost", itemDTO.getCost());
        namedParameterJdbcTemplate.update("Insert into Item(type, price, cost) values(:type,:price,:cost)", param, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public ItemDTO get(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = "select * from mydb1.item where id=:id";
        ItemDTO dto = namedParameterJdbcTemplate.queryForObject(sql, params, new ItemMapper());
        return dto;
    }

    @Override
    public List<ItemDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ItemDTO itemDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
     return   new NamedParameterJdbcTemplate(dataSource);
    }

    private class ItemMapper implements RowMapper<ItemDTO> {

        @Override
        public ItemDTO mapRow(ResultSet rs, int i) throws SQLException {
            ItemDTO dto = new ItemDTO();
            dto.setType(rs.getString("type"));
            dto.setPrice(rs.getDouble("price"));
            dto.setCost(rs.getDouble("cost"));
            return dto;
        }
    }

}
