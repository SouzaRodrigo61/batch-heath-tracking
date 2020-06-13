package br.com.lifetracking.util;

import com.opencsv.bean.ColumnPositionMappingStrategy;

import br.com.lifetracking.models.BrasilCovid;

public class ColumnStrategy {
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(BrasilCovid.class);
        String[] columns = new String[] {"epidemiological_week","date","order_for_place","state","city","city_ibge_code","place_type","last_available_confirmed","last_available_confirmed_per_100k_inhabitants","new_confirmed","last_available_deaths","new_deaths","last_available_death_rate","estimated_population_2019","is_last","is_repeated"}; 
        strategy.setColumnMapping(columns);
        return strategy;
    }
}