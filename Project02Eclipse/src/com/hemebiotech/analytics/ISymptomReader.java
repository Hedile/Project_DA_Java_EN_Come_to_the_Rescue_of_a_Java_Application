package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> GetSymptoms();

	/**
	 * compter toutes les occurrences de tout symptôme
	 * 
	 * @return une liste non ordonnée de symptomes suivi du nombre d’occurrences.
	 */
	Map<String, Integer> OccurrenceCount(List<String> symptoms);

	/**
	 * 
	 * Trier les symptomes dans l'ordre alphabétique.
	 * 
	 * @return une liste de symptomes triée dans l'ordre alphbétique, chaque
	 *         symptome suivie du nombre d’occurrence.
	 */
	Map<String, Integer> SortedResult(Map<String, Integer> map);

	/**
	 *
	 * 
	 * @return générer un nouveau fichier texte nommé results.out qui liste chaque
	 *         symptôme dans l’ordre alphabétique, suivi du nombre d’occurrences
	 *         dans le fichier
	 * @throws IOException
	 */
	void GetResult(Map<String, Integer> result) throws IOException;

}
