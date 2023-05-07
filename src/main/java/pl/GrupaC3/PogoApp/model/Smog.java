package pl.GrupaC3.PogoApp.model;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Smog {
	public String getStationName() {
		return stationName;
	}

	public Date getStCalcDate() {
		return stCalcDate;
	}

	public IndexLevel getStIndexLevel() {
		return stIndexLevel;
	}

	public IndexLevel getSo2IndexLevel() {
		return so2IndexLevel;
	}

	public IndexLevel getNo2IndexLevel() {
		return no2IndexLevel;
	}

	public IndexLevel getPm10IndexLevel() {
		return pm10IndexLevel;
	}

	public IndexLevel getPm25IndexLevel() {
		return pm25IndexLevel;
	}

	public IndexLevel getO3IndexLevel() {
		return o3IndexLevel;
	}

	public boolean isStIndexStatus() {
		return stIndexStatus;
	}

	public class IndexLevel {
		public int id;
		public String indexLevelName;

		public IndexLevel() {
			indexLevelName = "Brak Danych";
		}

		@Override
		public String toString() {
			return indexLevelName;
		}
	}

	public String stationName = "Brak danych";

	@JsonProperty("id")
	public int id;

	@JsonProperty("stCalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date stCalcDate;

	@JsonProperty("stIndexLevel")
	public IndexLevel stIndexLevel;

	@JsonProperty("so2IndexLevel")
	public IndexLevel so2IndexLevel;

	@JsonProperty("no2IndexLevel")
	public IndexLevel no2IndexLevel;

	@JsonProperty("pm10IndexLevel")
	public IndexLevel pm10IndexLevel;

	@JsonProperty("pm25IndexLevel")
	public IndexLevel pm25IndexLevel;

	@JsonProperty("o3IndexLevel")
	public IndexLevel o3IndexLevel;

	@JsonProperty("stIndexStatus")
	public boolean stIndexStatus;

	public Smog() {
		this.no2IndexLevel = new IndexLevel();
		this.so2IndexLevel = new IndexLevel();
		this.o3IndexLevel = new IndexLevel();
		this.pm25IndexLevel = new IndexLevel();
		this.pm10IndexLevel = new IndexLevel();
		this.stIndexLevel = new IndexLevel();
	}
}