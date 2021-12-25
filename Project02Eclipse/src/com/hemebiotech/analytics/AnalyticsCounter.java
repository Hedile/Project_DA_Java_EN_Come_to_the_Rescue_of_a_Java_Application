package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

	// lecture du fichier
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

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

	public Map<String, Integer> SortedResult() {// compter toutes les occurrences de tout symptôme et Trier les
												// symptomes dans l'ordre alphabétique
		List<String> symptoms = new ArrayList<String>();
		symptoms = GetSymptoms();
		Map<String, Integer> result = new TreeMap<String, Integer>();

		for (String symptom : symptoms) {
			int frequence = Collections.frequency(symptoms, symptom);
			result.put(symptom, frequence);
		}

		return result;

	}

	public void GetResult() throws IOException {// générer un nouveau fichier texte et enregistrer les symptômes triées
		try {

			File file = new File("Project02Eclipse/result.out");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			Map<String, Integer> result = new TreeMap<String, Integer>();
			result = SortedResult();
			for (Entry<String, Integer> entry : result.entrySet()) {
				fw.write(entry + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
