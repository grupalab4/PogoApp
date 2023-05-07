package pl.GrupaC3.PogoApp.model;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.Date;

public class Smog {
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

	@JsonProperty("id")
	public int id;

	@JsonProperty("stCalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date stCalcDate;

	@JsonProperty("stIndexLevel")
	public IndexLevel stIndexLevel;

	@JsonProperty("stSourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date stSourceDataDate;

	@JsonProperty("so2CalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date so2CalcDate;

	@JsonProperty("so2IndexLevel")
	public IndexLevel so2IndexLevel;

	@JsonProperty("so2SourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date so2SourceDataDate;

	@JsonProperty("no2CalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date no2CalcDate;

	@JsonProperty("no2IndexLevel")
	public IndexLevel no2IndexLevel;

	@JsonProperty("no2SourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date no2SourceDataDate;

	@JsonProperty("pm10CalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date pm10CalcDate;

	@JsonProperty("pm10IndexLevel")
	public IndexLevel pm10IndexLevel;

	@JsonProperty("pm10SourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date pm10SourceDataDate;

	@JsonProperty("pm25CalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date pm25CalcDate;

	@JsonProperty("pm25IndexLevel")
	public IndexLevel pm25IndexLevel;

	@JsonProperty("pm25SourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date pm25SourceDataDate;

	@JsonProperty("o3CalcDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date o3CalcDate;

	@JsonProperty("o3IndexLevel")
	public IndexLevel o3IndexLevel;

	@JsonProperty("o3SourceDataDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Warsaw")
	public Date o3SourceDataDate;

	@JsonProperty("stIndexStatus")
	public boolean stIndexStatus;

	@JsonProperty("stIndexCrParam")
	public String stIndexCrParam;

	public Smog() {
		this.no2IndexLevel = new IndexLevel();
		this.so2IndexLevel = new IndexLevel();
		this.o3IndexLevel = new IndexLevel();
		this.pm25IndexLevel = new IndexLevel();
		this.pm10IndexLevel = new IndexLevel();
		this.stIndexLevel = new IndexLevel();
	}
}