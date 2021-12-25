package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AnalyticsCounter implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public AnalyticsCounter(String filepath) {
		this.filepath = filepath;
	}

	public List<String> GetSymptoms() {
		List<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Map<String, Integer> OccurrenceCount(List<String> symptoms) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (map.containsKey(symptom)) {
				map.put(symptom, map.get(symptom) + 1);
			} else {
				map.put(symptom, 1);
			}
		}
		return map;
	}

	public Map<String, Integer> SortedResult(Map<String, Integer> map) {

		Map<String, Integer> result = new TreeMap<String, Integer>();
		result.putAll(map);
		return result;

	}

	public void GetResult(Map<String, Integer> result) throws IOException {

		try {

			File file = new File("Project02Eclipse/result.out");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			for (Entry<String, Integer> entry : result.entrySet()) {
				fw.write(entry + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
