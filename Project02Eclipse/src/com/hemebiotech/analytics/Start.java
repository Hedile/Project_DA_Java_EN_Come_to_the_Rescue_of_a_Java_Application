package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Start {

	public static void main(String[] args) throws IOException {
		// instancier la classe AnalyticsCounter
		AnalyticsCounter file = new AnalyticsCounter("Project02Eclipse/symptoms.txt");
		List<String> result = new ArrayList<String>();
		// lecture du fichier
		result = file.GetSymptoms();
		Map<String, Integer> map = new HashMap<String, Integer>();
		// compter toutes les occurrences de tout sympt�me
		map = file.OccurrenceCount(result);
		Map<String, Integer> resultTrie = new TreeMap<String, Integer>();
		// Trier les symptomes dans l'ordre alphab�tique
		resultTrie = file.SortedResult(map);
		// g�n�rer un nouveau fichier texte et enregistrer les sympt�mes tri�es
		file.GetResult(resultTrie);

	}

}
