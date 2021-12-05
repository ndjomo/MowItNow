package publicis.exercice.ndjomo.tondeuse.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Utilitaire de pargination d'une liste en sous listes
 * Utilisé pour produire la liste des instructions pour chaque tondeuse
 * @param <T>
 */
public class PaginationList<T> {


    /**
     * Produire une liste de sous listes de taille 'pageSize'
     * @param bigList
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> getPages(Collection<T> bigList, Integer pageSize) {
        if (bigList == null) return Collections.emptyList();
        List<T> list = new ArrayList<>(bigList);

        if (pageSize == null || pageSize <= 0 || pageSize > list.size()) {
            pageSize = list.size();
        }

        int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
        List<List<T>> pages = new ArrayList<>(numPages);

        for (int pageNum = 0; pageNum < numPages;) {
            pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
        }

        return pages;
    }
}
