package br.com.lifetracking.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class BrasilCovidEntity extends PanacheEntity {
    
	@Column
    public String epidemiological_week;
	@Column
    public String date;
	@Column
    public String order_for_place;
	@Column
    public String state;
	@Column
    public String city;
	@Column
    public String city_ibge_code;
	@Column
    public String place_type;
	@Column
    public String last_available_confirmed;
	@Column
    public String last_available_confirmed_per_100k_inhabitants;
	@Column
    public String new_confirmed;
	@Column
    public String last_available_deaths;
	@Column
    public String new_deaths;
	@Column
    public String last_available_death_rate;
	@Column
    public String estimated_population_2019;
	@Column
    public String is_last;
	@Column
    public String is_repeated;
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrasilCovidEntity [");
		if (city != null) {
			builder.append("city=").append(city).append(", ");
		}
		if (city_ibge_code != null) {
			builder.append("city_ibge_code=").append(city_ibge_code).append(", ");
		}
		if (date != null) {
			builder.append("date=").append(date).append(", ");
		}
		if (epidemiological_week != null) {
			builder.append("epidemiological_week=").append(epidemiological_week).append(", ");
		}
		if (estimated_population_2019 != null) {
			builder.append("estimated_population_2019=").append(estimated_population_2019).append(", ");
		}
		if (is_last != null) {
			builder.append("is_last=").append(is_last).append(", ");
		}
		if (is_repeated != null) {
			builder.append("is_repeated=").append(is_repeated).append(", ");
		}
		if (last_available_confirmed != null) {
			builder.append("last_available_confirmed=").append(last_available_confirmed).append(", ");
		}
		if (last_available_confirmed_per_100k_inhabitants != null) {
			builder.append("last_available_confirmed_per_100k_inhabitants=")
					.append(last_available_confirmed_per_100k_inhabitants).append(", ");
		}
		if (last_available_death_rate != null) {
			builder.append("last_available_death_rate=").append(last_available_death_rate).append(", ");
		}
		if (last_available_deaths != null) {
			builder.append("last_available_deaths=").append(last_available_deaths).append(", ");
		}
		if (new_confirmed != null) {
			builder.append("new_confirmed=").append(new_confirmed).append(", ");
		}
		if (new_deaths != null) {
			builder.append("new_deaths=").append(new_deaths).append(", ");
		}
		if (order_for_place != null) {
			builder.append("order_for_place=").append(order_for_place).append(", ");
		}
		if (place_type != null) {
			builder.append("place_type=").append(place_type).append(", ");
		}
		if (state != null) {
			builder.append("state=").append(state);
		}
		builder.append("]");
		return builder.toString();
	}

    
}