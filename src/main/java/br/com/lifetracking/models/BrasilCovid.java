package br.com.lifetracking.models;

public class BrasilCovid {
    private String epidemiological_week;
    private String date;
    private String order_for_place;
    private String state;
    private String city;
    private String city_ibge_code;
    private String place_type;
    private String last_available_confirmed;
    private String last_available_confirmed_per_100k_inhabitants;
    private String new_confirmed;
    private String last_available_deaths;
    private String new_deaths;
    private String last_available_death_rate;
    private String estimated_population_2019;
    private String is_last;
    private String is_repeated;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrasilCovid [");
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

	/**
	 * @return the epidemiological_week
	 */
	public String getEpidemiological_week() {
		return epidemiological_week;
	}

	/**
	 * @param epidemiological_week the epidemiological_week to set
	 */
	public void setEpidemiological_week(String epidemiological_week) {
		this.epidemiological_week = epidemiological_week;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the order_for_place
	 */
	public String getOrder_for_place() {
		return order_for_place;
	}

	/**
	 * @param order_for_place the order_for_place to set
	 */
	public void setOrder_for_place(String order_for_place) {
		this.order_for_place = order_for_place;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the city_ibge_code
	 */
	public String getCity_ibge_code() {
		return city_ibge_code;
	}

	/**
	 * @param city_ibge_code the city_ibge_code to set
	 */
	public void setCity_ibge_code(String city_ibge_code) {
		this.city_ibge_code = city_ibge_code;
	}

	/**
	 * @return the place_type
	 */
	public String getPlace_type() {
		return place_type;
	}

	/**
	 * @param place_type the place_type to set
	 */
	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	/**
	 * @return the last_available_confirmed
	 */
	public String getLast_available_confirmed() {
		return last_available_confirmed;
	}

	/**
	 * @param last_available_confirmed the last_available_confirmed to set
	 */
	public void setLast_available_confirmed(String last_available_confirmed) {
		this.last_available_confirmed = last_available_confirmed;
	}

	/**
	 * @return the last_available_confirmed_per_100k_inhabitants
	 */
	public String getLast_available_confirmed_per_100k_inhabitants() {
		return last_available_confirmed_per_100k_inhabitants;
	}

	/**
	 * @param last_available_confirmed_per_100k_inhabitants the last_available_confirmed_per_100k_inhabitants to set
	 */
	public void setLast_available_confirmed_per_100k_inhabitants(String last_available_confirmed_per_100k_inhabitants) {
		this.last_available_confirmed_per_100k_inhabitants = last_available_confirmed_per_100k_inhabitants;
	}

	/**
	 * @return the new_confirmed
	 */
	public String getNew_confirmed() {
		return new_confirmed;
	}

	/**
	 * @param new_confirmed the new_confirmed to set
	 */
	public void setNew_confirmed(String new_confirmed) {
		this.new_confirmed = new_confirmed;
	}

	/**
	 * @return the last_available_deaths
	 */
	public String getLast_available_deaths() {
		return last_available_deaths;
	}

	/**
	 * @param last_available_deaths the last_available_deaths to set
	 */
	public void setLast_available_deaths(String last_available_deaths) {
		this.last_available_deaths = last_available_deaths;
	}

	/**
	 * @return the new_deaths
	 */
	public String getNew_deaths() {
		return new_deaths;
	}

	/**
	 * @param new_deaths the new_deaths to set
	 */
	public void setNew_deaths(String new_deaths) {
		this.new_deaths = new_deaths;
	}

	/**
	 * @return the last_available_death_rate
	 */
	public String getLast_available_death_rate() {
		return last_available_death_rate;
	}

	/**
	 * @param last_available_death_rate the last_available_death_rate to set
	 */
	public void setLast_available_death_rate(String last_available_death_rate) {
		this.last_available_death_rate = last_available_death_rate;
	}

	/**
	 * @return the estimated_population_2019
	 */
	public String getEstimated_population_2019() {
		return estimated_population_2019;
	}

	/**
	 * @param estimated_population_2019 the estimated_population_2019 to set
	 */
	public void setEstimated_population_2019(String estimated_population_2019) {
		this.estimated_population_2019 = estimated_population_2019;
	}

	/**
	 * @return the is_last
	 */
	public String getIs_last() {
		return is_last;
	}

	/**
	 * @param is_last the is_last to set
	 */
	public void setIs_last(String is_last) {
		this.is_last = is_last;
	}

	/**
	 * @return the is_repeated
	 */
	public String getIs_repeated() {
		return is_repeated;
	}

	/**
	 * @param is_repeated the is_repeated to set
	 */
	public void setIs_repeated(String is_repeated) {
		this.is_repeated = is_repeated;
	}

    
    
}

